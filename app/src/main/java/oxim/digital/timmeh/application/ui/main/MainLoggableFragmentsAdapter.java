package oxim.digital.timmeh.application.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import oxim.digital.timmeh.application.ui.loggableFragment.LoggableFragment;
import oxim.digital.timmeh.domain.Loggable;

public final class MainLoggableFragmentsAdapter extends FragmentStatePagerAdapter {

    private final List<Loggable> loggables;
    private final int loggablesSize;

    public MainLoggableFragmentsAdapter(final FragmentManager fragmentManager, final List<Loggable> loggables) {
        super(fragmentManager);
        this.loggables = loggables;
        this.loggablesSize = loggables.size();
    }

    @Override
    public Fragment getItem(final int position) {
        if (loggablesSize <= position) {
            throw new RuntimeException("Unhandled item position -> " + position);
        }

        return LoggableFragment.newInstance(loggables.get(position).key);
    }

    public String getLoggableKey(final int index) {
        return loggables.get(index).key;
    }

    @Override
    public int getCount() {
        return loggables.size();
    }
}
