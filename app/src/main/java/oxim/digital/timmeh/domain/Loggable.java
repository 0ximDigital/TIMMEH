package oxim.digital.timmeh.domain;

public enum Loggable {
    TASK("TASK"),
    MEETING("MEETING"),
    CODE_REVIEW("CODE_REVIEW"),
    BUILD("BUILD"),
    RESEARCH("RESEARCH"),
    ESTIMATE("ESTIMATE");

    public final String key;

    Loggable(final String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
