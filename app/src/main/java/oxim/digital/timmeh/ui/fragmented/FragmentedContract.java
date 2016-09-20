package oxim.digital.timmeh.ui.fragmented;

import oxim.digital.timmeh.ui.BaseView;
import oxim.digital.timmeh.ui.ScopedPresenter;

public interface FragmentedContract {

    interface View extends BaseView {

        void runTask();

        void stopTask();

    }

    interface Presenter extends ScopedPresenter<View> {

    }
}
