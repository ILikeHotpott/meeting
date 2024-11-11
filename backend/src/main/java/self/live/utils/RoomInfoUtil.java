package self.live.utils;

import cn.hutool.core.util.IdUtil;
import self.live.constant.GlobalConstant;
import self.live.entity.RoomInfo;
import self.live.exception.LiveException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomInfoUtil {
    private static List<RoomInfo> roomInfoList = new ArrayList<>();

    public static String createRoom(String roomName, int maxNumber) {
        for (RoomInfo roomInfo : roomInfoList) {
            if (roomInfo.getRoomName().equals(roomName)) {
                throw new LiveException("Room title already exists！");
            }
        }
        if (maxNumber < GlobalConstant.ROOM_MIN_NUMBER) {
            throw new LiveException("Room number cannot be less than 2!");
        }
        if (maxNumber > GlobalConstant.ROOM_MAX_NUMBER) {
            throw new LiveException("Exceeds the maximum number of rooms！");
        }
        String id = IdUtil.objectId();
        roomInfoList.add(new RoomInfo(
                roomName,
                maxNumber,
                id,
                new ArrayList<>()
        ));
        return id;
    }

    public static String enterRoom(String roomName) {
        boolean isRoomExit = false;
        String id = IdUtil.objectId();
        for (RoomInfo roomInfo : roomInfoList) {
            if (roomInfo.getRoomName().equals(roomName)) {
                isRoomExit = true;
                int size = roomInfo.getRoomMemberIds().size();
                if (size >= roomInfo.getMaxNumber() - 1) {
                    throw new LiveException("The room is full！");
                }
                roomInfo.getRoomMemberIds().add(id);
                //进入房间更新时间
                roomInfo.setEndChangeDate(new Date());
                break;
            }
        }
        if (!isRoomExit) {
            throw new LiveException("Room does not exist！");
        }
        return id;
    }

    public static List<String> queryRoomMemberIds(String roomName, String id) {
        RoomInfo byRoomName = findByRoomName(roomName);
        List<String> roomMemberIds = byRoomName.getRoomMemberIds();
        if (id.equals(byRoomName.getRoomAdminId())) {
            return roomMemberIds;
        }
        int index = roomMemberIds.indexOf(id);
        if (index == -1) {
            throw new LiveException("Id does not exist！");
        }
        ArrayList<String> ids = new ArrayList<>();
        for (int i = roomMemberIds.indexOf(id) + 1; i < roomMemberIds.size(); i++) {
            ids.add(roomMemberIds.get(i));
        }
        return ids;
    }

    public static RoomInfo findByRoomName(String roomName) {
        for (RoomInfo roomInfo : roomInfoList) {
            if (roomInfo.getRoomName().equals(roomName)) {
                return roomInfo;
            }
        }
        throw new LiveException("Room does not exist！");
    }

    public static RoomInfo findById(String id) {
        for (RoomInfo roomInfo : roomInfoList) {
            if (id.equals(roomInfo.getRoomAdminId()) || roomInfo.getRoomMemberIds().contains(id)) {
                return roomInfo;
            }
        }
        return null;
    }

    private static void checkRoomNum() {
        roomInfoList.removeIf(roomInfo -> null == roomInfo.getRoomAdminId() && roomInfo.getRoomMemberIds().size() == 0);
    }

    public static void outRoom(String id) {
        RoomInfo roomInfo = findById(id);
        if (null == roomInfo) {
            //如果未查到不处理
            return;
        }
        if (roomInfo.getRoomMemberIds().contains(id)) {
            roomInfo.getRoomMemberIds().remove(id);
        } else {
            roomInfo.setRoomAdminId(null);
        }
        //退出房间，更新时间
        roomInfo.setEndChangeDate(new Date());
        checkRoomNum();
    }

    public static void clear() {
        roomInfoList.clear();
    }

    public static void clearTask() {

        checkRoomNum();
        Date date = new Date();
        ArrayList<RoomInfo> clearRoomInfoList = new ArrayList<>();
        for (RoomInfo roomInfo : roomInfoList) {
            if (date.getTime() - roomInfo.getEndChangeDate().getTime() > 28800000) {
                clearRoomInfoList.add(roomInfo);
                continue;
            }
            int size = roomInfo.getRoomMemberIds().size();
            if (roomInfo.getRoomAdminId() != null) {
                size++;
            }
            if (size < 3 && date.getTime() - roomInfo.getEndChangeDate().getTime() > 14400000) {
                clearRoomInfoList.add(roomInfo);
                continue;
            }
            if (size < 2 && date.getTime() - roomInfo.getEndChangeDate().getTime() > 7200000) {
                clearRoomInfoList.add(roomInfo);
            }
        }
        roomInfoList.removeAll(clearRoomInfoList);
    }
}
