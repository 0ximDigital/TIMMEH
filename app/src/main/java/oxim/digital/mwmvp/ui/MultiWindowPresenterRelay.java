package oxim.digital.mwmvp.ui;

public final class MultiWindowPresenterRelay implements PresenterRelay {

    private final boolean isInMultiWindow;

    private ScopedPresenter presenter;

    public MultiWindowPresenterRelay(final boolean isInMultiWindow) {
        this.isInMultiWindow = isInMultiWindow;
    }

    @Override
    public void onStart() {
        if (isInMultiWindow) {
            presenter.activate();
        }
    }

    @Override
    public void onResume() {
        if (!isInMultiWindow) {
            presenter.activate();
        }
    }

    @Override
    public void onPause() {
        if (!isInMultiWindow) {
            presenter.deactivate();
        }
    }

    @Override
    public void onStop() {
        if (isInMultiWindow) {
            presenter.deactivate();
        }
    }

    @Override
    public void attachPresenter(final ScopedPresenter presenter) {
        this.presenter = presenter;
    }
}
