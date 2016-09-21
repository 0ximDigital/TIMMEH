package oxim.digital.timmeh.application.activity;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import oxim.digital.timmeh.application.ui.fragmented.FragmentedContract;
import oxim.digital.timmeh.application.ui.fragmented.FragmentedPresenter;
import oxim.digital.timmeh.application.ui.loggableFragment.LoggableContract;
import oxim.digital.timmeh.application.ui.loggableFragment.LoggablePresenter;
import oxim.digital.timmeh.application.ui.newLoggableItem.NewLoggableItemContract;
import oxim.digital.timmeh.application.ui.newLoggableItem.NewLoggableItemPresenter;
import oxim.digital.timmeh.application.ui.router.loggables.LoggablesRouter;
import oxim.digital.timmeh.data.mapper.LoggableMapper;

@Module
public final class FragmentPresenterModule {

    private final Fragment fragment;

    public FragmentPresenterModule(final Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    FragmentedContract.Presenter provideFragmentedPresenter() {
        return new FragmentedPresenter();
    }

    @Provides
    LoggableContract.Presenter provideLoggableFragmentPresenter(final LoggableMapper loggableMapper) {
        return new LoggablePresenter(loggableMapper);
    }

    @Provides
    NewLoggableItemContract.Presenter provideNewLoggableItemPresenter(final LoggablesRouter loggablesRouter) {
        return new NewLoggableItemPresenter(loggablesRouter);
    }
}
