package oxim.digital.mwmvp.application;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModule {

    private final MwMvpApplication mwMvpApplication;

    public ApplicationModule(MwMvpApplication mwMvpApplication) {
        this.mwMvpApplication = mwMvpApplication;
    }

    @Provides
    @Singleton
    MwMvpApplication provideRosettaApplication() {
        return this.mwMvpApplication;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideContext() {
        return this.mwMvpApplication;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return mwMvpApplication.getResources();
    }

    interface Exposes {

        MwMvpApplication rosettaApplication();

        @ForApplication
        Context context();

        Resources resources();
    }
}
