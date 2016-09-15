package oxim.digital.mwmvp.ui;

public final class SingleWindowPresenterRelay implements PresenterRelay {

    private ScopedPresenter presenter;

    public SingleWindowPresenterRelay() {
    }

    @Override
    public void onStart() {
        // No-op
    }

    @Override
    public void onResume() {
        presenter.activate();
    }

    @Override
    public void onPause() {
        presenter.deactivate();
    }

    @Override
    public void onStop() {
        // No-op
    }

    @Override
    public void attachPresenter(final ScopedPresenter presenter) {
        this.presenter = presenter;
    }
}
