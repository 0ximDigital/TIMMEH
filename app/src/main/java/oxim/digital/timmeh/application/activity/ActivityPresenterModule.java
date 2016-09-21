package oxim.digital.timmeh.application.activity;

import dagger.Module;
import dagger.Provides;
import oxim.digital.timmeh.application.ui.main.MainContract;
import oxim.digital.timmeh.application.ui.main.MainPresenter;
import oxim.digital.timmeh.application.ui.router.loggables.LoggablesRouter;

@Module
public final class ActivityPresenterModule {

    @Provides
    @ActivityScope
    MainContract.Presenter provideMainContractPresenter(final LoggablesRouter loggablesRouter) {
        return new MainPresenter(loggablesRouter);
    }
}
