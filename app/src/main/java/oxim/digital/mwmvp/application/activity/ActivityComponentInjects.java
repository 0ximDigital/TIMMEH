package oxim.digital.mwmvp.application.activity;

import oxim.digital.mwmvp.ui.fragmented.FragmentHolderActivity;
import oxim.digital.mwmvp.ui.main.MainActivity;

public interface ActivityComponentInjects {

    void inject(MainActivity mainActivity);

    void inject(FragmentHolderActivity fragmentHolderActivity);
}
