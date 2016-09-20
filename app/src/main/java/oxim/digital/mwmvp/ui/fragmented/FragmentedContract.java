package oxim.digital.mwmvp.ui.fragmented;

import oxim.digital.mwmvp.ui.BaseView;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public interface FragmentedContract {

    interface View extends BaseView {

        void runTask();

        void stopTask();

    }

    interface Presenter extends ScopedPresenter<View> {

    }
}
