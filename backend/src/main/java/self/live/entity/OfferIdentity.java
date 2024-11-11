package self.live.entity;

public class OfferIdentity {
    private String fromId;
    private String toId;
    private String roomName;
    private String offer;
    private String candidate;

    public OfferIdentity(String fromId, String toId, String roomName, String offer, String candidate) {
        this.fromId = fromId;
        this.toId = toId;
        this.roomName = roomName;
        this.offer = offer;
        this.candidate = candidate;
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

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "OfferIdentity{" +
                "fromId='" + fromId + '\'' +
                ", toId='" + toId + '\'' +
                ", roomName='" + roomName + '\'' +
                ", offer='" + offer + '\'' +
                ", candidate='" + candidate + '\'' +
                '}';
    }
}
