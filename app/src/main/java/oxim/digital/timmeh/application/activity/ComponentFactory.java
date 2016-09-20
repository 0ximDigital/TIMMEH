package oxim.digital.timmeh.application.activity;

import android.support.v4.app.Fragment;

import oxim.digital.timmeh.application.ApplicationComponent;
import oxim.digital.timmeh.application.TimmehApplication;

public final class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(TimmehApplication timmehApplication) {
        return ApplicationComponent.Initializer.init(timmehApplication);
    }

    public static ActivityComponent createActivityComponent(DaggerActivity daggerActivity, TimmehApplication timmehApplication) {
        return ActivityComponent.Initializer.init(daggerActivity, timmehApplication.getApplicationComponent());
    }

    public static FragmentComponent createFragmentComponent(Fragment fragment, DaggerActivity daggerActivity) {
        return FragmentComponent.Initializer.init(fragment, daggerActivity.getActivityComponent());
    }
}
