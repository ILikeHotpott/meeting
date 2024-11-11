package self.live.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.live.entity.AnswerIdentity;
import self.live.entity.OfferIdentity;
import self.live.service.SignTransferService;
import self.live.utils.Assert;

@RestController
@RequestMapping("/sign-transfer")
public class SignTransferController {
    private final SignTransferService signTransferService;

    public SignTransferController(SignTransferService signTransferService) {
        this.signTransferService = signTransferService;
    }

    @PostMapping("/add-offer-identity")
    public void addOfferIdentity(@RequestBody OfferIdentity offerIdentity) {
        String fromId = offerIdentity.getFromId();
        String toId = offerIdentity.getToId();
        String roomName = offerIdentity.getRoomName();
        String offer = offerIdentity.getOffer();
        String candidate = offerIdentity.getCandidate();
        Assert.isNotBlank(fromId, "Sender");
        Assert.isNotBlank(toId, "Receiver");
        Assert.isNotBlank(roomName, "Room Title");
        Assert.isNotBlank(offer, "offer info");
        Assert.isNotBlank(candidate, "ice candidate info");
        signTransferService.addOfferIdentity(fromId, toId, roomName, offer, candidate);
    }

    @PostMapping("/add-answer-identity")
    public void addAnswerIdentity(@RequestBody AnswerIdentity answerIdentity) {
        String fromId = answerIdentity.getFromId();
        String toId = answerIdentity.getToId();
        String roomName = answerIdentity.getRoomName();
        String answer = answerIdentity.getAnswer();
        Assert.isNotBlank(fromId, "Sender");
        Assert.isNotBlank(toId, "Receiver");
        Assert.isNotBlank(roomName, "Room Title");
        Assert.isNotBlank(answer, "Answer info");
        signTransferService.addAnswerIdentity(fromId, toId, roomName, answer);
    }
}