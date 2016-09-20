package oxim.digital.timmeh.ui;

public interface ScopedPresenter<T extends BaseView> {

    void setView(T view);

    void activate();

    void deactivate();
}
