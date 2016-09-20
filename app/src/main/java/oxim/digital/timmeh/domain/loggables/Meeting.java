package oxim.digital.timmeh.domain.loggables;

import android.os.Parcel;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import oxim.digital.timmeh.R;

public final class Meeting implements Loggable {

    @StringRes private final int titleResId;
    @StringRes private final int subtitleResId;
    @DrawableRes private final int iconResId;

    public Meeting() {
        this.titleResId = R.string.Meeting;
        this.subtitleResId = R.string.MeetingSubtitle;
        this.iconResId = R.drawable.ic_meeting;
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

    protected Meeting(Parcel in) {
        this.titleResId = in.readInt();
        this.subtitleResId = in.readInt();
        this.iconResId = in.readInt();
    }

    public static final Creator<Meeting> CREATOR = new Creator<Meeting>() {

        @Override
        public Meeting createFromParcel(Parcel source) {return new Meeting(source);}

        @Override
        public Meeting[] newArray(int size) {return new Meeting[size];}
    };
}
