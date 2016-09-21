package oxim.digital.timmeh.application.activity;

import dagger.Component;
import oxim.digital.timmeh.application.ApplicationComponent;

@ActivityScope
@Component(
        dependencies = {ApplicationComponent.class},
        modules = {
                ActivityModule.class,
                ActivityPresenterModule.class,
                ActivityDataModule.class
        }
)
public interface ActivityComponent extends ActivityComponentInjects, ActivityComponentExposes {

    final class Initializer {

        static public ActivityComponent init(DaggerActivity daggerActivity, ApplicationComponent applicationComponent) {
            return DaggerActivityComponent.builder()
                                          .applicationComponent(applicationComponent)
                                          .activityModule(new ActivityModule(daggerActivity))
                                          .activityPresenterModule(new ActivityPresenterModule())
                                          .activityDataModule(new ActivityDataModule())
                                          .build();
        }

        // No instances
        private Initializer() {
        }
    }
}
