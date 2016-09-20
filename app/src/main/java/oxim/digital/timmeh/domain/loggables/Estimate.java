package oxim.digital.timmeh.domain.loggables;

import android.os.Parcel;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import oxim.digital.timmeh.R;

public final class Estimate implements Loggable {

    @StringRes private final int titleResId;
    @StringRes private final int subtitleResId;
    @DrawableRes private final int iconResId;

    public Estimate() {
        this.titleResId = R.string.Estimate;
        this.subtitleResId = R.string.EstimateSubtitle;
        this.iconResId = R.drawable.ic_estimate;
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

    protected Estimate(Parcel in) {
        this.titleResId = in.readInt();
        this.subtitleResId = in.readInt();
        this.iconResId = in.readInt();
    }

    public static final Creator<Estimate> CREATOR = new Creator<Estimate>() {

        @Override
        public Estimate createFromParcel(Parcel source) {return new Estimate(source);}

        @Override
        public Estimate[] newArray(int size) {return new Estimate[size];}
    };
}
