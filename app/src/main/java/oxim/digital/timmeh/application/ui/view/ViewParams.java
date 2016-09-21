package oxim.digital.timmeh.application.ui.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public final class ViewParams implements Parcelable {

    public final int width;
    public final int height;

    public final int x;
    public final int y;

    public static ViewParams forView(final View view) {
        final int[] position = new int[2];
        view.getLocationOnScreen(position);
        final int width = view.getWidth();
        final int height = view.getHeight();
        final int x = position[0] + width / 2;
        final int y = position[1] + height / 2;
        return new ViewParams(width, height, x, y);
    }

    public ViewParams(final int width, final int height, final int x, final int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeInt(this.x);
        dest.writeInt(this.y);
    }

    protected ViewParams(Parcel in) {
        this.width = in.readInt();
        this.height = in.readInt();
        this.x = in.readInt();
        this.y = in.readInt();
    }

    public static final Parcelable.Creator<ViewParams> CREATOR = new Parcelable.Creator<ViewParams>() {

        @Override
        public ViewParams createFromParcel(Parcel source) {return new ViewParams(source);}

        @Override
        public ViewParams[] newArray(int size) {return new ViewParams[size];}
    };
}
