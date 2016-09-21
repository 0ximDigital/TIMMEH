package oxim.digital.timmeh.application;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.raizlabs.android.dbflow.BuildConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import oxim.digital.timmeh.application.activity.ComponentFactory;

public final class TimmehApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = ComponentFactory.createApplicationComponent(this);
        applicationComponent.inject(this);

        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
