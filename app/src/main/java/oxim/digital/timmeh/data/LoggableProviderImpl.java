package oxim.digital.timmeh.data;

import java.util.Arrays;
import java.util.List;

import oxim.digital.timmeh.domain.Loggable;

public final class LoggableProviderImpl implements LoggableProvider {

    @Override
    public List<Loggable> getLoggables() {
        return Arrays.asList(Loggable.values());
    }
}
