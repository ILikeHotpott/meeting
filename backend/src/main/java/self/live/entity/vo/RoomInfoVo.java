package self.live.entity.vo;

public class RoomInfoVo {
    private String id;
    private String roomName;
    private int maxNumber;

    public RoomInfoVo(String id, String roomName, int maxNumber) {
        this.id = id;
        this.roomName = roomName;
        this.maxNumber = maxNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public String toString() {
        return "RoomInfoVo{" +
                "id='" + id + '\'' +
                ", roomName='" + roomName + '\'' +
                ", maxNumber=" + maxNumber +
                '}';
    }
}
