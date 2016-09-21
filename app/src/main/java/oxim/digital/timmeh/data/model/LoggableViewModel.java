package oxim.digital.timmeh.data.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import oxim.digital.timmeh.R;
import oxim.digital.timmeh.domain.Loggable;

public final class LoggableViewModel {

    public static final LoggableViewModel EMPTY = new LoggableViewModel(Loggable.TASK.key, R.string.Task, R.string.TaskSubtitle, R.drawable.ic_task);

    public final String loggableKey;

    @StringRes
    public final int titleResId;

    @StringRes
    public final int subtitleResId;

    @DrawableRes
    public final int iconResId;

    public LoggableViewModel(final String loggableKey, final int titleResId, final int subtitleResId, final int iconResId) {
        this.loggableKey = loggableKey;
        this.titleResId = titleResId;
        this.subtitleResId = subtitleResId;
        this.iconResId = iconResId;
    }
}
