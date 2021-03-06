package oxim.digital.timmeh.application.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import oxim.digital.timmeh.application.ui.MultiWindowPresenterRelay;
import oxim.digital.timmeh.application.ui.PresenterRelay;
import oxim.digital.timmeh.application.ui.SingleWindowPresenterRelay;
import oxim.digital.timmeh.application.ui.router.Router;
import oxim.digital.timmeh.application.ui.router.RouterImpl;
import oxim.digital.timmeh.application.ui.router.loggables.LoggablesRouter;
import oxim.digital.timmeh.application.ui.router.loggables.LoggablesRouterHolder;
import oxim.digital.timmeh.application.ui.router.loggables.LoggablesRouterImpl;

@Module
public final class ActivityModule {

    private final DaggerActivity daggerActivity;

    public ActivityModule(DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Provides
    @ActivityScope
    @ForActivity
    Context provideActivityContext() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {
        return daggerActivity.getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    Router provideRouter() {
        return new RouterImpl();
    }

    @Provides
    @ActivityScope
    PresenterRelay providePresenterRelay() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return new MultiWindowPresenterRelay(daggerActivity.isInMultiWindowMode());
        } else {
            return new SingleWindowPresenterRelay();
        }
    }

    @Provides
    @ActivityScope
    LoggablesRouter provideLoggablesRouter(final FragmentManager fragmentManager) {
        if (daggerActivity instanceof LoggablesRouterHolder) {
            return new LoggablesRouterImpl(fragmentManager, ((LoggablesRouterHolder) daggerActivity).provideContainerId());
        } else {
            throw new RuntimeException("Cannot provide LoggableRouter");
        }
    }

    interface Exposes {

        Router router();

        FragmentManager fragmentManager();

        PresenterRelay presenterRelay();

        LoggablesRouter loggablesRouter();
    }
}
