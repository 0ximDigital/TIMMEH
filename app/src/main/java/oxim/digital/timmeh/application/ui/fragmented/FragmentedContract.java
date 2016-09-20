package oxim.digital.timmeh.application.ui.fragmented;

import oxim.digital.timmeh.application.ui.BaseView;
import oxim.digital.timmeh.application.ui.ScopedPresenter;

public interface FragmentedContract {

    interface View extends BaseView {

        void runTask();

        void stopTask();

    }

    interface Presenter extends ScopedPresenter<View> {

    }
}
