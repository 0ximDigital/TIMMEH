package oxim.digital.timmeh.application.activity;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import oxim.digital.timmeh.ui.fragmented.FragmentedContract;
import oxim.digital.timmeh.ui.fragmented.FragmentedPresenter;

@Module
public final class FragmentPresenterModule {

    private final Fragment fragment;

    public FragmentPresenterModule(final Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    FragmentedContract.Presenter provideFragmentedPresenter() {
        return new FragmentedPresenter();
    }
}
