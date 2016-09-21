package oxim.digital.timmeh.application.ui.newLoggableItem;

import oxim.digital.timmeh.application.ui.BaseView;
import oxim.digital.timmeh.application.ui.ScopedPresenter;

public interface NewLoggableItemContract {

    interface View extends BaseView {

        void remove();

    }

    interface Presenter extends ScopedPresenter<View> {

        void start(String loggableKey);

        void closeScreen();
    }
}
