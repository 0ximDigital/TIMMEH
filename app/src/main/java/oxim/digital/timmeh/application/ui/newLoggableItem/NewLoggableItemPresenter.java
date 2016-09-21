package oxim.digital.timmeh.application.ui.newLoggableItem;

import oxim.digital.timmeh.application.ui.BasePresenter;
import oxim.digital.timmeh.application.ui.router.loggables.LoggablesRouter;

public final class NewLoggableItemPresenter extends BasePresenter<NewLoggableItemContract.View> implements NewLoggableItemContract.Presenter {

    private final LoggablesRouter loggablesRouter;

    public NewLoggableItemPresenter(final LoggablesRouter loggablesRouter) {
        this.loggablesRouter = loggablesRouter;
    }

    @Override
    public void start(final String loggableKey) {
        // TODO
    }

    @Override
    public void closeScreen() {
        loggablesRouter.hideNewLoggablesItemScreen();
    }
}
