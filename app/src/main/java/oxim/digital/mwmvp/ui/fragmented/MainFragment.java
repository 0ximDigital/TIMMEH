package oxim.digital.mwmvp.ui.fragmented;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.FragmentComponent;
import oxim.digital.mwmvp.application.activity.MwFragment;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public final class MainFragment extends MwFragment implements FragmentedContract.View {

    @Inject
    FragmentedContract.Presenter presenter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fragmented, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @NonNull
    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void runTask() {
        // TODO
    }

    @Override
    public void stopTask() {
        // TODO
    }

    @Override
    public void showMessage(final String message) {
        // TODO
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }
}
