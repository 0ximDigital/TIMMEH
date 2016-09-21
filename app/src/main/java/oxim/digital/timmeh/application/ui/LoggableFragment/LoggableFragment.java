package oxim.digital.timmeh.application.ui.LoggableFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import oxim.digital.timmeh.R;
import oxim.digital.timmeh.application.activity.FragmentComponent;
import oxim.digital.timmeh.application.activity.MwFragment;
import oxim.digital.timmeh.application.ui.ScopedPresenter;
import oxim.digital.timmeh.data.model.LoggableViewModel;

public final class LoggableFragment extends MwFragment implements LoggableContract.View {

    private static final String KEY_LOGGABLE = "LOGGABLE_KEY";

    @Inject
    LoggableContract.Presenter presenter;

    @Bind(R.id.loggable_title)
    TextView title;

    @Bind(R.id.loggable_subtitle)
    TextView subtitle;

    @Bind(R.id.loggable_icon)
    ImageView icon;

    private String loggableKey;

    public static LoggableFragment newInstance(final String loggableKey) {
        LoggableFragment fragment = new LoggableFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(KEY_LOGGABLE, loggableKey);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extractArguments();
    }

    private void extractArguments() {
        final Bundle arguments = getArguments();
        if (arguments == null) {
            throw new RuntimeException("Cannot handle null loggable!");
        }

        this.loggableKey = arguments.getString(KEY_LOGGABLE);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_loggable, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        presenter.start(loggableKey);
    }

    @Override
    public void fillView(final LoggableViewModel loggableViewModel) {
        title.setText(loggableViewModel.titleResId);
        subtitle.setText(loggableViewModel.subtitleResId);
        icon.setImageResource(loggableViewModel.iconResId);
    }

    @Override
    public void showMessage(final String message) {

    }

    @NonNull
    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }
}
