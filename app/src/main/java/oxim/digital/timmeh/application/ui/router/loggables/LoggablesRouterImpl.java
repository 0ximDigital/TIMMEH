package oxim.digital.timmeh.application.ui.router.loggables;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import oxim.digital.timmeh.application.ui.newLoggableItem.NewLoggableItemFragment;
import oxim.digital.timmeh.application.ui.view.BackPropagatingFragment;
import oxim.digital.timmeh.application.ui.view.ViewParams;

public final class LoggablesRouterImpl implements LoggablesRouter {

    final FragmentManager fragmentManager;

    @IdRes
    private final int fragmentContainerId;

    public LoggablesRouterImpl(final FragmentManager fragmentManager, final int fragmentContainerId) {
        this.fragmentManager = fragmentManager;
        this.fragmentContainerId = fragmentContainerId;
    }

    @Override
    public void showNewLoggableItemScreen(final String loggableKey, final ViewParams viewParams) {
        final Fragment fragment = fragmentManager.findFragmentByTag(NewLoggableItemFragment.TAG);
        if (fragment == null) {
            final NewLoggableItemFragment newLoggableItemFragment = NewLoggableItemFragment.newInstance(loggableKey, viewParams);
            fragmentManager.beginTransaction()
                           .add(fragmentContainerId, newLoggableItemFragment, NewLoggableItemFragment.TAG)
                           .commit();
        }
    }

    @Override
    public void hideNewLoggablesItemScreen() {
        final Fragment fragment = fragmentManager.findFragmentByTag(NewLoggableItemFragment.TAG);
        if (fragment != null) {
            fragmentManager.beginTransaction()
                           .remove(fragment)
                           .commit();
        }
    }

    @Override
    public boolean propagateBackToTopFragment() {
        final List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments == null || fragments.isEmpty()) {
            return false;
        }
        for (int i = fragments.size() - 1; i >= 0; i--) {
            final Fragment fragment = fragments.get(i);
            if (fragment != null && fragment.isVisible()) {
                if (fragment instanceof BackPropagatingFragment) {
                    return ((BackPropagatingFragment) fragment).onBack();
                }
                break;
            }
        }
        return false;
    }
}
