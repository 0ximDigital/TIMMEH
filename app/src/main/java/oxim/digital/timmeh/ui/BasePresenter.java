package oxim.digital.timmeh.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.annimon.stream.Optional;

import java.lang.ref.WeakReference;

import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter<T extends BaseView> implements ScopedPresenter<T> {

    private CompositeSubscription compositeSubscription;
    private WeakReference<T> viewWeakReference;

    @Override
    public void setView(final T view) {
        viewWeakReference = new WeakReference<>(view);
    }

    @Override
    public void activate() {
        compositeSubscription = new CompositeSubscription();
    }

    protected void addSubscription(final Subscription subscription) {
        if (compositeSubscription != null) {
            compositeSubscription.add(subscription);
        }
    }

    protected void removeSubscription(final Subscription subscription) {
        if (compositeSubscription != null) {
            compositeSubscription.remove(subscription);
        }
    }

    @Override
    public void deactivate() {
        if (compositeSubscription != null && !compositeSubscription.isUnsubscribed()) {
            compositeSubscription.unsubscribe();
            compositeSubscription = null;
        }
    }

    protected void doIfViewNotNull(final Action1<T> whenViewNotNull) {
        final T view = getNullableView();
        if (view != null) {
            whenViewNotNull.call(view);
        }
    }

    @NonNull
    protected Optional<T> getOptionalView() {
        if (viewWeakReference == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(viewWeakReference.get());
        }
    }

    @NonNull
    protected T getViewOrEmpty(final @NonNull T emptyView) {
        if (viewWeakReference == null) {
            return emptyView;
        } else {
            final T view = viewWeakReference.get();
            return view == null ? emptyView : view;
        }
    }

    protected boolean isActive() {
        return (compositeSubscription != null && !compositeSubscription.isUnsubscribed());
    }

    @Nullable
    protected T getNullableView() {
        return viewWeakReference == null ? null : viewWeakReference.get();
    }

    protected final void doNothing() {
        // convenience method for empty subscriptions
    }

    protected final void logError(final Throwable throwable) {
        Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
        doIfViewNotNull(view -> view.showMessage(throwable.getMessage()));
    }
}
