package oxim.digital.timmeh.application;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModule {

    private final TimmehApplication timmehApplication;

    public ApplicationModule(TimmehApplication timmehApplication) {
        this.timmehApplication = timmehApplication;
    }

    @Provides
    @Singleton
    TimmehApplication provideTimmehApplication() {
        return this.timmehApplication;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideContext() {
        return this.timmehApplication;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return timmehApplication.getResources();
    }

    interface Exposes {

        TimmehApplication timmehApplication();

        @ForApplication
        Context context();

        Resources resources();
    }
}
