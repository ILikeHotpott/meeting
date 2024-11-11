package self.live.controller;

import org.springframework.web.bind.annotation.*;
import self.live.service.SignTransferExtService;
import self.live.utils.Assert;
import self.live.utils.OvercoatSseExceptionUtil;

@RestController
@RequestMapping("/sign-transfer-ext")
public class SignTransferExtController {
    private final SignTransferExtService signTransferExtService;

    public SignTransferExtController(SignTransferExtService signTransferExtService) {
        this.signTransferExtService = signTransferExtService;
    }

    @GetMapping(value = "/get-new-offer", produces = "text/event-stream;charset=UTF-8")
    public String getNewOffer(@RequestParam("roomName") String roomName, @RequestParam("id") String id) {
        return OvercoatSseExceptionUtil.handleException(() -> {
            Assert.isNotBlank(roomName, "Room Title");
            Assert.isNotBlank(id, "Receiver");
            return signTransferExtService.getNewOffer(roomName, id);
        });
    }

    @GetMapping(value = "/get-new-answer", produces = "text/event-stream;charset=UTF-8")
    public String getNewAnswer(@RequestParam("roomName") String roomName, @RequestParam("id") String id) {
        return OvercoatSseExceptionUtil.handleException(() -> {
            Assert.isNotBlank(roomName, "Room Title");
            Assert.isNotBlank(id, "Receiver");
            return signTransferExtService.getNewAnswer(roomName, id);
        });
    }
}
