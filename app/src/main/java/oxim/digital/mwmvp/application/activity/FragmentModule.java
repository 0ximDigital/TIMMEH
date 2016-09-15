package oxim.digital.mwmvp.application.activity;

import android.support.v4.app.Fragment;

import dagger.Module;

@Module
public final class FragmentModule {

    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

}
