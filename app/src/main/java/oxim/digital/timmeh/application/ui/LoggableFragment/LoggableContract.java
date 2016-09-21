package oxim.digital.timmeh.application.ui.LoggableFragment;

import oxim.digital.timmeh.application.ui.BaseView;
import oxim.digital.timmeh.application.ui.ScopedPresenter;
import oxim.digital.timmeh.data.model.LoggableViewModel;

public interface LoggableContract {

    interface View extends BaseView {

        void fillView(LoggableViewModel loggableViewModel);

    }

    interface Presenter extends ScopedPresenter<View> {

        void start(String loggableKey);

    }
}
