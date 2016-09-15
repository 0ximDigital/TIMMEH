package oxim.digital.mwmvp.application.activity;

import dagger.Component;
import oxim.digital.mwmvp.application.ApplicationComponent;

@ActivityScope
@Component(
        dependencies = {ApplicationComponent.class},
        modules = {
                ActivityModule.class,
                ActivityPresenterModule.class
        }
)
public interface ActivityComponent extends ActivityComponentInjects, ActivityComponentExposes {

    final class Initializer {

        static public ActivityComponent init(DaggerActivity daggerActivity, ApplicationComponent applicationComponent) {
            return DaggerActivityComponent.builder()
                                          .applicationComponent(applicationComponent)
                                          .activityModule(new ActivityModule(daggerActivity))
                                          .activityPresenterModule(new ActivityPresenterModule())
                                          .build();
        }

        // No instances
        private Initializer() {
        }
    }
}
