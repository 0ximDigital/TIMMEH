package oxim.digital.mwmvp.application.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import oxim.digital.mwmvp.ui.PresenterRelay;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public abstract class MwActivity extends DaggerActivity {

    @Inject
    PresenterRelay presenterRelay;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
