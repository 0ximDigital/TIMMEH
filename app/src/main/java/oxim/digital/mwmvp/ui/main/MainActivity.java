package oxim.digital.mwmvp.ui.main;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.ActivityComponent;
import oxim.digital.mwmvp.application.activity.DaggerActivity;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public class MainActivity extends DaggerActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @Bind(R.id.spinny_thingy)
    View spinnyView;

    private Animation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.setView(this);

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotation);
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected ScopedPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void runTask() {
        spinView();
    }

    @Override
    public void stopTask() {
        stopView();
    }

    private void spinView() {
        spinnyView.startAnimation(rotateAnimation);
    }

    private void stopView() {
        spinnyView.clearAnimation();
    }

    @Override
    public void showMessage(final String message) {
        Snackbar.make(findViewById(R.id.content_root), message, Snackbar.LENGTH_SHORT).show();
    }
}
