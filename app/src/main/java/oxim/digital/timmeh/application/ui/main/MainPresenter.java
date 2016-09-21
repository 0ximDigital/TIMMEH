package oxim.digital.timmeh.application.ui.main;

import oxim.digital.timmeh.application.ui.BasePresenter;
import oxim.digital.timmeh.application.ui.router.loggables.LoggablesRouter;
import oxim.digital.timmeh.application.ui.view.ViewParams;

public final class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    final LoggablesRouter loggablesRouter;

    public MainPresenter(final LoggablesRouter loggablesRouter) {
        this.loggablesRouter = loggablesRouter;
    }

    @Override
    public void addLoggableItem(final String loggableKey, final ViewParams viewParams) {
        loggablesRouter.showNewLoggableItemScreen(loggableKey, viewParams);
    }

    @Override
    public boolean onBack() {
        return loggablesRouter.propagateBackToTopFragment();
    }
}
