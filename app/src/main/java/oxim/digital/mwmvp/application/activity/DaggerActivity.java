package oxim.digital.mwmvp.application.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import oxim.digital.mwmvp.application.MwMvpApplication;
import oxim.digital.mwmvp.ui.PresenterRelay;
import oxim.digital.mwmvp.ui.ScopedPresenter;
import oxim.digital.mwmvp.ui.router.Router;

public abstract class DaggerActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Inject
    Router router;

    @Inject
    PresenterRelay presenterRelay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getActivityComponent());

        presenterRelay.attachPresenter(getPresenter());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenterRelay.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenterRelay.onResume();
    }

    protected abstract void inject(ActivityComponent activityComponent);

    @NonNull
    protected abstract ScopedPresenter getPresenter();

    @Override
    protected void onPause() {
        presenterRelay.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        presenterRelay.onStop();
        super.onStop();
    }

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
