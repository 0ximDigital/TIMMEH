package oxim.digital.timmeh.application.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import oxim.digital.timmeh.application.ui.LoggableFragment.LoggableFragment;
import oxim.digital.timmeh.domain.loggables.Build;
import oxim.digital.timmeh.domain.loggables.CodeReview;
import oxim.digital.timmeh.domain.loggables.Estimate;
import oxim.digital.timmeh.domain.loggables.Meeting;
import oxim.digital.timmeh.domain.loggables.Research;
import oxim.digital.timmeh.domain.loggables.Task;

public final class MainLoggableFragmentsAdapter extends FragmentStatePagerAdapter {

    private static final int LOGGABLE_ITEM_COUNT = 6;

    public MainLoggableFragmentsAdapter(final FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case 0:
                return LoggableFragment.newInstance(new Task());
            case 1:
                return LoggableFragment.newInstance(new Meeting());
            case 2:
                return LoggableFragment.newInstance(new CodeReview());
            case 3:
                return LoggableFragment.newInstance(new Build());
            case 4:
                return LoggableFragment.newInstance(new Research());
            case 5:
                return LoggableFragment.newInstance(new Estimate());
            default:
                throw new RuntimeException("Unhandled item position!");
        }
    }

    @Override
    public int getCount() {
        return LOGGABLE_ITEM_COUNT;
    }
}
