package oxim.digital.timmeh.application.ui.main;

import oxim.digital.timmeh.application.ui.BaseView;
import oxim.digital.timmeh.application.ui.ScopedPresenter;

public interface MainContract {

    interface View extends BaseView {

        void showNewLoggableItemDialog();

    }

    interface Presenter extends ScopedPresenter<View> {

        void addLoggableItem(int loggableId);
    }
}
