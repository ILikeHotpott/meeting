package self.live.entity.bo;

public class SseDataBo {
    private String data;
    private String event;
    private String id;

    public SseDataBo(String data, String event, String id) {
        this.data = data;
        this.event = event;
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "event: " + event + "\n" +
                "data: " + data + "\n" +
                "id: " + id + "\n\n";
    }
}
