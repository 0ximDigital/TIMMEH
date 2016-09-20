package oxim.digital.timmeh.application.activity;

import dagger.Module;
import dagger.Provides;
import oxim.digital.timmeh.ui.main.MainContract;
import oxim.digital.timmeh.ui.main.MainPresenter;

@Module
public final class ActivityPresenterModule {

    @Provides
    @ActivityScope
    MainContract.Presenter provideMainContractPresenter() {
        return new MainPresenter();
    }

}
