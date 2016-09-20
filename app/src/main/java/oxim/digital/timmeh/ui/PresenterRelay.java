package oxim.digital.timmeh.ui;

public interface PresenterRelay {

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void attachPresenter(ScopedPresenter scopedPresenter);
}
