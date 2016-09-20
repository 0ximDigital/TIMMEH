package oxim.digital.mwmvp.ui.fragmented;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.ActivityComponent;
import oxim.digital.mwmvp.application.activity.DaggerActivity;

public final class FragmentHolderActivity extends DaggerActivity {

    @Inject
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            final Fragment fragment = MainFragment.newInstance();
            fragmentManager.beginTransaction()
                           .add(R.id.fragment_container, fragment)
                           .commit();
        }
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
