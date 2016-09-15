package oxim.digital.mwmvp.application;

import android.app.Application;

import oxim.digital.mwmvp.application.activity.ComponentFactory;

public final class MwMvpApplication extends Application {

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
