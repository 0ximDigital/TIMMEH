package oxim.digital.timmeh.data.mapper;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import oxim.digital.timmeh.R;
import oxim.digital.timmeh.data.model.LoggableViewModel;
import oxim.digital.timmeh.domain.Loggable;

public final class LoggableMapperImpl implements LoggableMapper {

    @Override
    public List<LoggableViewModel> toViewModels(final List<Loggable> loggables) {
        return Stream.of(loggables)
                     .map(this::toViewModel)
                     .collect(Collectors.toList());
    }

    @Override
    public LoggableViewModel toViewModel(final Loggable loggable) {
        switch (loggable) {
            case TASK:
                return new LoggableViewModel(loggable.key, R.string.Task, R.string.TaskSubtitle, R.drawable.ic_task);
            case MEETING:
                return new LoggableViewModel(loggable.key, R.string.Meeting, R.string.MeetingSubtitle, R.drawable.ic_meeting);
            case CODE_REVIEW:
                return new LoggableViewModel(loggable.key, R.string.CodeReview, R.string.CodeReviewSubtitle, R.drawable.ic_code_review);
            case BUILD:
                return new LoggableViewModel(loggable.key, R.string.Build, R.string.BuildSubtitle, R.drawable.ic_build);
            case RESEARCH:
                return new LoggableViewModel(loggable.key, R.string.Research, R.string.ResearchSubtitle, R.drawable.ic_research);
            case ESTIMATE:
                return new LoggableViewModel(loggable.key, R.string.Estimate, R.string.EstimateSubtitle, R.drawable.ic_estimate);
        }
        return LoggableViewModel.EMPTY;
    }
}
