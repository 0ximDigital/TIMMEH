package oxim.digital.timmeh.domain.loggables;

import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public interface Loggable extends Parcelable {

    @StringRes int getTitle();

    @StringRes int getSubtitle();

    @DrawableRes int getIcon();

}
