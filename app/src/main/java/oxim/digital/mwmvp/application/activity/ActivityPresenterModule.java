package oxim.digital.mwmvp.application.activity;

import dagger.Module;
import dagger.Provides;
import oxim.digital.mwmvp.ui.main.MainContract;
import oxim.digital.mwmvp.ui.main.MainPresenter;

@Module
public final class ActivityPresenterModule {

    @Provides
    @ActivityScope
    MainContract.Presenter provideMainContractPresenter() {
        return new MainPresenter();
    }

}
