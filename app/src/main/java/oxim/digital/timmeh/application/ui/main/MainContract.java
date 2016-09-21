package oxim.digital.timmeh.application.ui.main;

import oxim.digital.timmeh.application.ui.BaseView;
import oxim.digital.timmeh.application.ui.ScopedPresenter;
import oxim.digital.timmeh.application.ui.view.ViewParams;

public interface MainContract {

    interface View extends BaseView {

    }

    interface Presenter extends ScopedPresenter<View> {

        void addLoggableItem(String loggableKey, ViewParams viewParams);

        boolean onBack();
    }
}
