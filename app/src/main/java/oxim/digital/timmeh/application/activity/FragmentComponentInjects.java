package oxim.digital.timmeh.application.activity;

import oxim.digital.timmeh.application.ui.LoggableFragment.LoggableFragment;
import oxim.digital.timmeh.application.ui.fragmented.MainFragment;

public interface FragmentComponentInjects {

    void inject(MainFragment mainFragment);

    void inject(LoggableFragment loggableFragment);
}
