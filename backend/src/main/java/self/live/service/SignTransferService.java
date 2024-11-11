package self.live.service;

public interface SignTransferService {
    void addOfferIdentity(String fromId, String toId, String roomName, String offer, String candidate);

    void addAnswerIdentity(String fromId, String toId, String roomName, String answer);
}
