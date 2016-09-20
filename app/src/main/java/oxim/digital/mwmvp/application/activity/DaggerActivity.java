package oxim.digital.mwmvp.application.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import oxim.digital.mwmvp.application.MwMvpApplication;
import oxim.digital.mwmvp.ui.router.Router;

public abstract class DaggerActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Inject
    Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getActivityComponent());
    }

    protected abstract void inject(ActivityComponent activityComponent);

    public MwMvpApplication getMwMvpApplication() {
        return (MwMvpApplication) getApplication();
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this, getMwMvpApplication());
        }
        return activityComponent;
    }
}
