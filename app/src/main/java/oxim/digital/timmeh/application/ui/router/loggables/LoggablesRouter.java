package oxim.digital.timmeh.application.ui.router.loggables;

import oxim.digital.timmeh.application.ui.view.ViewParams;

public interface LoggablesRouter {

    void showNewLoggableItemScreen(String loggableKey, ViewParams viewParams);

    void hideNewLoggablesItemScreen();

    boolean propagateBackToTopFragment();
}
