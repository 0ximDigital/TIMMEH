package oxim.digital.mwmvp.application.activity;

import android.support.v4.app.Fragment;

import oxim.digital.mwmvp.application.ApplicationComponent;
import oxim.digital.mwmvp.application.MwMvpApplication;

public final class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(MwMvpApplication rosettaApplication) {
        return ApplicationComponent.Initializer.init(rosettaApplication);
    }

    public static ActivityComponent createActivityComponent(DaggerActivity daggerActivity, MwMvpApplication mwMvpApplication) {
        return ActivityComponent.Initializer.init(daggerActivity, mwMvpApplication.getApplicationComponent());
    }

    public static FragmentComponent createFragmentComponent(Fragment fragment, DaggerActivity daggerActivity) {
        return FragmentComponent.Initializer.init(fragment, daggerActivity.getActivityComponent());
    }
}
