package self.live.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import self.live.entity.bo.IdBo;
import self.live.entity.vo.RoomInfoVo;
import self.live.service.RoomInfoService;
import self.live.utils.Assert;

@RestController
@CrossOrigin(origins = "http://localhost:63344", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/room-info")
public class RoomInfoController {
    private final RoomInfoService roomInfoService;

    public RoomInfoController(RoomInfoService roomInfoService) {
        this.roomInfoService = roomInfoService;
    }

    @PostMapping("/create-room")
    public IdBo createRoom(@RequestBody RoomInfoVo roomInfoVo) {
        String roomName = roomInfoVo.getRoomName();
        int maxNumber = roomInfoVo.getMaxNumber();
        Assert.isNotBlank(roomName, "Room Title");
        Assert.isNotNull(maxNumber, "Room Max Number");
        return roomInfoService.createRoom(roomName, maxNumber);
    }

    @PostMapping("/enter-room")
    public IdBo enterRoom(@RequestBody RoomInfoVo roomInfoVo) {
        String roomName = roomInfoVo.getRoomName();
        Assert.isNotBlank(roomName, "Room Title");
        return roomInfoService.enterRoom(roomName);
    }


    @PostMapping("/out-room")
    public void outRoom(@RequestBody RoomInfoVo roomInfoVo) {
        String id = roomInfoVo.getId();
        Assert.isNotBlank(id, "Quit");
        roomInfoService.outRoom(id);
    }
}
