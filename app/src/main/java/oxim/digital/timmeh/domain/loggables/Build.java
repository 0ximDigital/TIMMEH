package oxim.digital.timmeh.domain.loggables;

import android.os.Parcel;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import oxim.digital.timmeh.R;

public final class Build implements Loggable {

    @StringRes private final int titleResId;
    @StringRes private final int subtitleResId;
    @DrawableRes private final int iconResId;

    public Build() {
        this.titleResId = R.string.Build;
        this.subtitleResId = R.string.BuildSubtitle;
        this.iconResId = R.drawable.ic_build;
    }



    @Override
    public int getTitle() {
        return titleResId;
    }

    @Override
    public int getSubtitle() {
        return subtitleResId;
    }

    @Override
    public int getIcon() {
        return iconResId;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.titleResId);
        dest.writeInt(this.subtitleResId);
        dest.writeInt(this.iconResId);
    }

    protected Build(Parcel in) {
        this.titleResId = in.readInt();
        this.subtitleResId = in.readInt();
        this.iconResId = in.readInt();
    }

    public static final Creator<Build> CREATOR = new Creator<Build>() {

        @Override
        public Build createFromParcel(Parcel source) {return new Build(source);}

        @Override
        public Build[] newArray(int size) {return new Build[size];}
    };
}
