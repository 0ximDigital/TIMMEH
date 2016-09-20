package oxim.digital.timmeh.application.ui.LoggableFragment;

import oxim.digital.timmeh.application.ui.BaseView;
import oxim.digital.timmeh.application.ui.ScopedPresenter;

public interface LoggableContract {

    interface View extends BaseView {

    }

    interface Presenter extends ScopedPresenter<View> {

    }
}
