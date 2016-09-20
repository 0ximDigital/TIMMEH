package oxim.digital.timmeh.application;

import android.app.Application;

import oxim.digital.timmeh.application.activity.ComponentFactory;

public final class TimmehApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = ComponentFactory.createApplicationComponent(this);
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
