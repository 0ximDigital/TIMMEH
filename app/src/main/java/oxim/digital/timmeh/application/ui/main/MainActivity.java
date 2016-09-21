package oxim.digital.timmeh.application.ui.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import oxim.digital.timmeh.R;
import oxim.digital.timmeh.application.activity.ActivityComponent;
import oxim.digital.timmeh.application.activity.MwActivity;
import oxim.digital.timmeh.application.ui.ScopedPresenter;
import oxim.digital.timmeh.application.ui.router.loggables.LoggablesRouterHolder;
import oxim.digital.timmeh.application.ui.view.ViewParams;

public class MainActivity extends MwActivity implements MainContract.View, LoggablesRouterHolder {

    @Inject
    MainContract.Presenter presenter;

    @Inject
    MainLoggableFragmentsAdapter mainLoggableFragmentsAdapter;

    @Bind(R.id.main_view_pager)
    ViewPager viewPager;

    @Bind(R.id.add_loggable_item_button)
    FloatingActionButton addLoggableItemButton;

    @IdRes
    @Override
    public int provideContainerId() {
        return R.id.fragment_container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.setView(this);

        setupView();
    }

    private void setupView() {
        viewPager.setAdapter(mainLoggableFragmentsAdapter);
        viewPager.setOffscreenPageLimit(mainLoggableFragmentsAdapter.getCount());
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected ScopedPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showMessage(final String message) {
        Snackbar.make(findViewById(R.id.content_root), message, Snackbar.LENGTH_SHORT).show();
    }

    @OnClick(R.id.add_loggable_item_button)
    public void onAddLoggableItemClick() {
        presenter.addLoggableItem(mainLoggableFragmentsAdapter.getLoggableKey(viewPager.getCurrentItem()), ViewParams.forView(addLoggableItemButton));
    }

    @Override
    public void onBackPressed() {
        if (!presenter.onBack()) {
            super.onBackPressed();
        }
    }
}
