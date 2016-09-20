package oxim.digital.timmeh.application.ui;

public interface ScopedPresenter<T extends BaseView> {

    void setView(T view);

    void activate();

    void deactivate();
}
