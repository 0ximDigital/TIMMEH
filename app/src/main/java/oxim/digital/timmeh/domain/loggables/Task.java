package oxim.digital.timmeh.domain.loggables;

import android.os.Parcel;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import oxim.digital.timmeh.R;

public final class Task implements Loggable {

    @StringRes private final int titleResId;
    @StringRes private final int subtitleResId;
    @DrawableRes private final int iconResId;

    public Task() {
        this.titleResId = R.string.Task;
        this.subtitleResId = R.string.TaskSubtitle;
        this.iconResId = R.drawable.ic_task;
    }

    @Override
    public int getTitle() {
        return titleResId;
    }

    @Override
    public int getIcon() {
        return iconResId;
    }

    @Override
    public int getSubtitle() {
        return subtitleResId;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.titleResId);
        dest.writeInt(this.subtitleResId);
        dest.writeInt(this.iconResId);
    }

    protected Task(Parcel in) {
        this.titleResId = in.readInt();
        this.subtitleResId = in.readInt();
        this.iconResId = in.readInt();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {

        @Override
        public Task createFromParcel(Parcel source) {return new Task(source);}

        @Override
        public Task[] newArray(int size) {return new Task[size];}
    };
}
