package oxim.digital.mwmvp.application.activity;

import android.support.v4.app.Fragment;

import dagger.Module;

@Module
public final class FragmentPresenterModule {

    private final Fragment fragment;

    public FragmentPresenterModule(final Fragment fragment) {
        this.fragment = fragment;
    }
}
