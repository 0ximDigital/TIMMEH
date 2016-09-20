package oxim.digital.timmeh.application.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import oxim.digital.timmeh.ui.PresenterRelay;
import oxim.digital.timmeh.ui.ScopedPresenter;

public abstract class MwFragment extends DaggerFragment {

    @Inject
    PresenterRelay presenterRelay;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterRelay.attachPresenter(getPresenter());
    }

    @NonNull
    public abstract ScopedPresenter getPresenter();

    @Override
    public void onStart() {
        super.onStart();
        presenterRelay.onStart();
        Log.i("LIFE", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        presenterRelay.onResume();
        Log.i("LIFE", "onResume");
    }

    @Override
    public void onPause() {
        Log.i("LIFE", "onPause");
        presenterRelay.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("LIFE", "onStop");
        presenterRelay.onStop();
        super.onStop();
    }
}
