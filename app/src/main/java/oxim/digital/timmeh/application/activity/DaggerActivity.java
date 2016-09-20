package oxim.digital.timmeh.application.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import oxim.digital.timmeh.application.TimmehApplication;
import oxim.digital.timmeh.ui.router.Router;

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

    public TimmehApplication getMwMvpApplication() {
        return (TimmehApplication) getApplication();
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this, getMwMvpApplication());
        }
        return activityComponent;
    }
}
