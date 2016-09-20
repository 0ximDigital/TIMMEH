package oxim.digital.timmeh.ui.main;

import oxim.digital.timmeh.ui.BaseView;
import oxim.digital.timmeh.ui.ScopedPresenter;

public interface MainContract {

    interface View extends BaseView {

        void runTask();

        void stopTask();

    }

    interface Presenter extends ScopedPresenter<View> {

    }
}
