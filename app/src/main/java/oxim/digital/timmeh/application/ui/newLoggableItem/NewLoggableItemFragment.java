package oxim.digital.timmeh.application.ui.newLoggableItem;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import oxim.digital.timmeh.R;
import oxim.digital.timmeh.application.activity.FragmentComponent;
import oxim.digital.timmeh.application.activity.MwFragment;
import oxim.digital.timmeh.application.ui.ScopedPresenter;
import oxim.digital.timmeh.application.ui.view.BackPropagatingFragment;
import oxim.digital.timmeh.application.ui.view.RevealFillView;
import oxim.digital.timmeh.application.ui.view.ViewParams;

public final class NewLoggableItemFragment extends MwFragment implements NewLoggableItemContract.View, BackPropagatingFragment {

    public static final String TAG = NewLoggableItemFragment.class.getSimpleName();

    private static final String KEY_LOGGABLE = "LOGGABLE_KEY";
    private static final String KEY_VIEW_PARAMS = "VIEW_PARAMS";

    @Bind(R.id.reveal_view)
    RevealFillView revealFillView;

    @Bind(R.id.new_loggable_item_content_container)
    ViewGroup contentContainer;

    @Inject
    NewLoggableItemContract.Presenter presenter;

    private String loggableKey;
    private ViewParams viewParams;

    public static NewLoggableItemFragment newInstance(final String loggableKey, final ViewParams viewParams) {
        NewLoggableItemFragment fragment = new NewLoggableItemFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(KEY_LOGGABLE, loggableKey);
        arguments.putParcelable(KEY_VIEW_PARAMS, viewParams);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extractArguments();
    }

    @Override
    public void remove() {
        contentContainer.setVisibility(View.GONE);
        revealFillView.startHideAnimation();
    }

    private void extractArguments() {
        final Bundle arguments = getArguments();
        if (arguments == null) {
            throw new RuntimeException("Cannot handle null loggable!");
        }

        this.loggableKey = arguments.getString(KEY_LOGGABLE);
        this.viewParams = arguments.getParcelable(KEY_VIEW_PARAMS);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_new_loggable_item, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.start(loggableKey);
        revealFillView.setAnimationListener(new RevealAnimationListener());
        revealFillView.startFillAnimation(viewParams.x, viewParams.y, true);
    }

    private void showContent() {
        contentContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(final String message) {

    }

    @NonNull
    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @OnClick(R.id.view_root)
    public void consumeClick() {

    }

    @Override
    public boolean onBack() {
        remove();
        return true;
    }

    private final class RevealAnimationListener implements RevealFillView.AnimationListener {

        @Override
        public void onRevealAnimationEnd() {
            showContent();
        }

        @Override
        public void onHideAnimationEnd() {
            presenter.closeScreen();
        }
    }
}
