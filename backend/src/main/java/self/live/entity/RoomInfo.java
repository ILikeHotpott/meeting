package self.live.entity;

import java.util.Date;
import java.util.List;

public class RoomInfo {
    private String roomName;
    private int maxNumber;
    private String roomAdminId;
    private List<String> roomMemberIds;
    private Date endChangeDate;

    public RoomInfo(String roomName, int maxNumber, String roomAdminId, List<String> roomMemberIds) {
        this.roomName = roomName;
        this.maxNumber = maxNumber;
        this.roomAdminId = roomAdminId;
        this.roomMemberIds = roomMemberIds;
        this.endChangeDate = new Date();
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

    public String getRoomAdminId() {
        return roomAdminId;
    }

    public void setRoomAdminId(String roomAdminId) {
        this.roomAdminId = roomAdminId;
    }

    public List<String> getRoomMemberIds() {
        return roomMemberIds;
    }

    public void setRoomMemberIds(List<String> roomMemberIds) {
        this.roomMemberIds = roomMemberIds;
    }

    public void setEndChangeDate(Date endChangeDate) {
        this.endChangeDate = endChangeDate;
    }

    public Date getEndChangeDate() {
        return endChangeDate;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "roomName='" + roomName + '\'' +
                ", maxNumber=" + maxNumber +
                ", roomAdminId='" + roomAdminId + '\'' +
                ", roomMemberIds=" + roomMemberIds +
                ", endChangeDate=" + endChangeDate +
                '}';
    }
}
