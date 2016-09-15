package oxim.digital.mwmvp.application;

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

        static public ApplicationComponent init(MwMvpApplication mwMvpApplication) {
            return DaggerApplicationComponent.builder()
                                             .applicationModule(new ApplicationModule(mwMvpApplication))
                                             .threadingModule(new ThreadingModule())
                                             .build();
        }

        private Initializer() {
        }
    }
}
