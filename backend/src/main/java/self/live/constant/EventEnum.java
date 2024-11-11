package self.live.constant;

public enum EventEnum {
    NEW_MEMBER("new_member", "New member joined"),
    NEW_OFFER("new_offer", "New offer created"),
    MEW_ANSWER("new_answer", "New answer created"),
    HANDLE_EXCEPTION("handle_exception", "Exception occurred");

    private final String eventName;
    private final String desc;

    EventEnum(String eventName, String desc) {
        this.eventName = eventName;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getEventName() {
        return eventName;
    }
}
