package oxim.digital.timmeh.application.ui.main;

import android.os.Bundle;
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

public class MainActivity extends MwActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @Inject
    MainLoggableFragmentsAdapter mainLoggableFragmentsAdapter;

    @Bind(R.id.main_view_pager)
    ViewPager viewPager;

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
    public void showNewLoggableItemDialog() {
        // TODO
    }

    @Override
    public void showMessage(final String message) {
        Snackbar.make(findViewById(R.id.content_root), message, Snackbar.LENGTH_SHORT).show();
    }

    @OnClick(R.id.add_loggable_item_button)
    public void onAddLoggableItemClick() {
        presenter.addLoggableItem(viewPager.getCurrentItem());
    }
}
