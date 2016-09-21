package oxim.digital.timmeh.data.mapper;

import java.util.List;

import oxim.digital.timmeh.data.model.LoggableViewModel;
import oxim.digital.timmeh.domain.Loggable;

public interface LoggableMapper {

    List<LoggableViewModel> toViewModels(List<Loggable> logggables);

    LoggableViewModel toViewModel(Loggable loggable);

}
