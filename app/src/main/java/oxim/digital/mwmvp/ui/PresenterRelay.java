package oxim.digital.mwmvp.ui;

public interface PresenterRelay {

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void attachPresenter(ScopedPresenter scopedPresenter);
}
