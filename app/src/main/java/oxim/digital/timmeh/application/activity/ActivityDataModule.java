package oxim.digital.timmeh.application.activity;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import oxim.digital.timmeh.application.ui.main.MainLoggableFragmentsAdapter;
import oxim.digital.timmeh.data.LoggableProvider;
import oxim.digital.timmeh.data.mapper.LoggableMapper;
import oxim.digital.timmeh.data.mapper.LoggableMapperImpl;

@Module
public final class ActivityDataModule {

    @Provides
    @ActivityScope
    MainLoggableFragmentsAdapter provideMainLoggableFragmentsAdapter(final FragmentManager fragmentManager, final LoggableProvider loggableProvider) {
        return new MainLoggableFragmentsAdapter(fragmentManager, loggableProvider.getLoggables());
    }

    @Provides
    LoggableMapper provideLoggableMapper() {
        return new LoggableMapperImpl();
    }

    interface Exposes {

        MainLoggableFragmentsAdapter mainLoggableFragmentsAdapter();

        LoggableMapper loggableMapper();
    }
}
