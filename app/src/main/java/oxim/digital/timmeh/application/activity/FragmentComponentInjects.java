package oxim.digital.timmeh.application.activity;

import oxim.digital.timmeh.application.ui.loggableFragment.LoggableFragment;
import oxim.digital.timmeh.application.ui.newLoggableItem.NewLoggableItemFragment;

public interface FragmentComponentInjects {

    void inject(LoggableFragment loggableFragment);

    void inject(NewLoggableItemFragment newLoggableItemFragment);
}
