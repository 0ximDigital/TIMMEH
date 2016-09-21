package oxim.digital.timmeh.application.ui.LoggableFragment;

import oxim.digital.timmeh.application.ui.BasePresenter;
import oxim.digital.timmeh.data.mapper.LoggableMapper;
import oxim.digital.timmeh.domain.Loggable;

public final class LoggablePresenter extends BasePresenter<LoggableContract.View> implements LoggableContract.Presenter {

    final LoggableMapper loggableMapper;

    private Loggable loggable;

    public LoggablePresenter(final LoggableMapper loggableMapper) {
        this.loggableMapper = loggableMapper;
    }

    @Override
    public void start(final String loggableKey) {
        this.loggable = Loggable.valueOf(loggableKey);
        populateView();
    }

    private void populateView() {
        doIfViewNotNull(view -> view.fillView(loggableMapper.toViewModel(loggable)));
    }
}
