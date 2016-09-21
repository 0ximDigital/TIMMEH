package oxim.digital.timmeh.application.activity;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import oxim.digital.timmeh.application.ui.LoggableFragment.LoggableContract;
import oxim.digital.timmeh.application.ui.LoggableFragment.LoggablePresenter;
import oxim.digital.timmeh.application.ui.fragmented.FragmentedContract;
import oxim.digital.timmeh.application.ui.fragmented.FragmentedPresenter;
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
}
