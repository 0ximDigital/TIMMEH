package oxim.digital.timmeh.application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ThreadingModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentInjects, ApplicationComponentExposes {

    final class Initializer {

        static public ApplicationComponent init(TimmehApplication timmehApplication) {
            return DaggerApplicationComponent.builder()
                                             .applicationModule(new ApplicationModule(timmehApplication))
                                             .threadingModule(new ThreadingModule())
                                             .build();
        }

        private Initializer() {
        }
    }
}
