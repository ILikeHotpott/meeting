package self.live.service.impl;

import org.springframework.stereotype.Service;
import self.live.entity.bo.IdBo;
import self.live.service.RoomInfoService;
import self.live.utils.RoomInfoUtil;
@Service
public class RoomInfoServiceImpl implements RoomInfoService {

    @Override
    public IdBo createRoom(String roomName, int maxNumber) {
        return new IdBo(RoomInfoUtil.createRoom(roomName, maxNumber));
    }

    @Override
    public IdBo enterRoom(String roomName) {
        return new IdBo(RoomInfoUtil.enterRoom(roomName));
    }

    @Override
    public void outRoom(String id) {
        RoomInfoUtil.outRoom(id);
    }
}
