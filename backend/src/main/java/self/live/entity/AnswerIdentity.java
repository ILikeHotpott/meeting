package self.live.entity;

public class AnswerIdentity {
    private String fromId;
    private String toId;
    private String roomName;
    private String answer;

    public AnswerIdentity(String fromId, String toId, String roomName, String answer) {
        this.fromId = fromId;
        this.toId = toId;
        this.roomName = roomName;
        this.answer = answer;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnswerIdentity{" +
                "fromId='" + fromId + '\'' +
                ", toId='" + toId + '\'' +
                ", roomName='" + roomName + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
