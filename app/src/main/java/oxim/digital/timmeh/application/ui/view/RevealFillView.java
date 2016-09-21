package oxim.digital.timmeh.application.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import oxim.digital.timmeh.R;

public final class RevealFillView extends View {

    public interface AnimationListener {

        void onRevealAnimationEnd();

        void onHideAnimationEnd();
    }

    private static final int HIDE_ANIMATION_DELAY_MS = 200;

    private static final int CORNER_SWEEP_ANGLE = 90;
    private static final float STROKE_WIDTH = 3.0f;

    private static final int DEFAULT_ANIMATION_DURATION_MS = 300;

    private final Region viewRegion = new Region();
    private final Path outlinePath = new Path();
    private final Region outlineRegion = new Region();
    private final Path circlePath = new Path();
    private final Region circleRegion = new Region();
    private final RectF circleRect = new RectF();

    private final Paint fillPaint;

    private final int[] position = new int[2];

    private ValueAnimator radiusAnimator;

    private int width;
    private int height;
    private int cornerRadius;
    private int cornerDiameter;

    private int circleRadius;

    private float x;
    private float y;

    private int animationDuration = DEFAULT_ANIMATION_DURATION_MS;

    private boolean handleClick;

    private boolean hasPendingAnimation;
    private PendingAnimationData pendingAnimationData;

    private AnimationListener animationListener;

    public RevealFillView(final Context context) {
        this(context, null);
    }

    public RevealFillView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RevealFillView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        fillPaint.setStrokeWidth(STROKE_WIDTH);
        fillPaint.setColor(Color.BLACK);

        if (attrs != null) {
            parseAttributes(attrs);
        }
    }

    private void parseAttributes(final AttributeSet attrs) {
        final TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.RevealFillView, 0, 0);
        try {
            fillPaint.setColor(typedArray.getColor(R.styleable.RevealFillView_revealFillColor, Color.BLACK));
            cornerRadius = (int) typedArray.getDimension(R.styleable.RevealFillView_radius, 0.0f);
            cornerDiameter = cornerRadius * 2;
            animationDuration = typedArray.getInteger(R.styleable.RevealFillView_animationDuration, DEFAULT_ANIMATION_DURATION_MS);
            handleClick = typedArray.getBoolean(R.styleable.RevealFillView_handleClick, false);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onSizeChanged(final int newWidth, final int newHeight, final int oldw, final int oldh) {
        super.onSizeChanged(newWidth, newHeight, oldw, oldh);
        width = newWidth;
        height = newHeight;
        getLocationOnScreen(position);

        final Rect viewRect = new Rect(0, 0, width, height);
        viewRegion.set(viewRect);

        createOutlinePath();
        createCirclePath();

        if (hasPendingAnimation) {
            hasPendingAnimation = false;
            startFillAnimation(pendingAnimationData.x, pendingAnimationData.y, pendingAnimationData.adjustToWindow);
        }
    }

    private void createOutlinePath() {
        final RectF cornerRect = new RectF();
        outlinePath.reset();
        outlinePath.moveTo(0, height - cornerRadius - STROKE_WIDTH);
        outlinePath.lineTo(0, cornerRadius + STROKE_WIDTH);
        cornerRect.set(0, 0, cornerDiameter + STROKE_WIDTH, cornerDiameter + STROKE_WIDTH);
        outlinePath.arcTo(cornerRect, 180, CORNER_SWEEP_ANGLE);                                             // top-left corner
        outlinePath.lineTo(width - cornerRadius - STROKE_WIDTH, 0);
        cornerRect.set(width - cornerDiameter - STROKE_WIDTH, 0, width, cornerDiameter + STROKE_WIDTH);
        outlinePath.arcTo(cornerRect, 270, CORNER_SWEEP_ANGLE);                                             // top-right corner
        outlinePath.lineTo(width, height - cornerRadius - STROKE_WIDTH);
        cornerRect.set(width - cornerDiameter - STROKE_WIDTH, height - cornerDiameter - STROKE_WIDTH, width, height);
        outlinePath.arcTo(cornerRect, 360, CORNER_SWEEP_ANGLE);                                             // bottom-right corner
        outlinePath.lineTo(cornerRadius + STROKE_WIDTH, height);
        cornerRect.set(0, height - cornerDiameter - STROKE_WIDTH, cornerDiameter + STROKE_WIDTH, height);   // bottom-left corner
        outlinePath.arcTo(cornerRect, 90, CORNER_SWEEP_ANGLE);
        outlinePath.close();
    }

    private void createCirclePath() {
        circleRect.set(x - circleRadius, y - circleRadius, x + circleRadius, y + circleRadius);
        circlePath.reset();
        circlePath.addOval(circleRect, Path.Direction.CW);
        circlePath.close();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        if (shouldClipCircle()) {
            drawClippedCircle(canvas);
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(final Canvas canvas) {
        canvas.drawOval(circleRect, fillPaint);
    }

    private void drawClippedCircle(final Canvas canvas) {
        outlineRegion.setPath(outlinePath, viewRegion);
        circleRegion.setPath(circlePath, viewRegion);
        circleRegion.op(outlineRegion, Region.Op.INTERSECT);

        final Path outline = circleRegion.getBoundaryPath();
        outline.close();
        canvas.drawPath(outline, fillPaint);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        if (!handleClick) {
            return super.onTouchEvent(event);
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            startFillAnimation(event.getX(), event.getY());
        }
        return super.onTouchEvent(event);
    }

    public void startFillAnimation() {
        startFillAnimation(width / 2, height / 2);
    }

    public void startFillAnimation(final float x, final float y) {
        startFillAnimation(x, y, false);
    }

    public void startFillAnimation(final float x, final float y, final boolean adjustToWindow) {
        if (width == 0 || height == 0) {
            hasPendingAnimation = true;
            pendingAnimationData = new PendingAnimationData(x, y, adjustToWindow);
            return;
        }
        if (radiusAnimator != null && radiusAnimator.isRunning()) {
            radiusAnimator.cancel();
        }

        if (adjustToWindow) {
            this.x = x - position[0];
            this.y = y - position[1];
        } else {
            this.x = x;
            this.y = y;
        }
        final int maxDrawRadius = (int) (Math.max(x - position[0], width - x) + Math.max(y - position[1], height - y));
        radiusAnimator = ValueAnimator.ofInt(0, maxDrawRadius);
        radiusAnimator.setDuration(animationDuration);
        radiusAnimator.setInterpolator(new AccelerateInterpolator());
        radiusAnimator.addUpdateListener(animation -> {
            circleRadius = (int) animation.getAnimatedValue();
            createCirclePath();
            invalidate();
        });
        radiusAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(final Animator animation) {
                if (animationListener != null) {
                    if (circleRadius == 0) {
                        animationListener.onHideAnimationEnd();
                    } else {
                        animationListener.onRevealAnimationEnd();
                    }
                }
                super.onAnimationEnd(animation);
            }
        });
        radiusAnimator.start();
    }

    public void startHideAnimation() {
        radiusAnimator.setStartDelay(HIDE_ANIMATION_DELAY_MS);
        radiusAnimator.reverse();
    }

    public void setAnimationListener(final AnimationListener animationListener) {
        this.animationListener = animationListener;
    }

    private boolean shouldClipCircle() {
        return ((x + circleRadius > width) || (y + circleRadius > height) || (x - circleRadius < 0) || (y - circleRadius < 0));
    }

    private static final class PendingAnimationData {

        final float x;
        final float y;
        final boolean adjustToWindow;

        public PendingAnimationData(final float x, final float y, final boolean adjustToWindow) {
            this.x = x;
            this.y = y;
            this.adjustToWindow = adjustToWindow;
        }
    }
}
