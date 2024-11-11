package self.live.service;

import self.live.entity.bo.IdBo;


public interface RoomInfoService {
    IdBo createRoom(String roomName,int maxNumber);

    IdBo enterRoom(String roomName);

    void outRoom(String id);
}
