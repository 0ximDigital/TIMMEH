package oxim.digital.timmeh.application.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class DaggerFragment extends Fragment {

    private FragmentComponent fragmentComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getFragmentComponent());
    }

    protected abstract void inject(FragmentComponent fragmentComponent);

    protected FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            final DaggerActivity daggerActivity = ((DaggerActivity) getActivity());
            fragmentComponent = ComponentFactory.createFragmentComponent(this, daggerActivity);
        }

        return fragmentComponent;
    }
}