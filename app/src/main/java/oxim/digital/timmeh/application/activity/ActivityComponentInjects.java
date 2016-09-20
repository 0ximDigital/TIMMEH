package oxim.digital.timmeh.application.activity;

import oxim.digital.timmeh.application.ui.fragmented.FragmentHolderActivity;
import oxim.digital.timmeh.application.ui.main.MainActivity;

public interface ActivityComponentInjects {

    void inject(MainActivity mainActivity);

    void inject(FragmentHolderActivity fragmentHolderActivity);
}
