package oxim.digital.timmeh.domain.loggables;

import android.os.Parcel;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import oxim.digital.timmeh.R;

public final class CodeReview implements Loggable {

    @StringRes private final int titleResId;
    @StringRes private final int subtitleResId;
    @DrawableRes private final int iconResId;

    public CodeReview() {
        this.titleResId = R.string.CodeReview;
        this.subtitleResId = R.string.CodeReviewSubtitle;
        this.iconResId = R.drawable.ic_code_review;
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

    protected CodeReview(Parcel in) {
        this.titleResId = in.readInt();
        this.subtitleResId = in.readInt();
        this.iconResId = in.readInt();
    }

    public static final Creator<CodeReview> CREATOR = new Creator<CodeReview>() {

        @Override
        public CodeReview createFromParcel(Parcel source) {return new CodeReview(source);}

        @Override
        public CodeReview[] newArray(int size) {return new CodeReview[size];}
    };
}
