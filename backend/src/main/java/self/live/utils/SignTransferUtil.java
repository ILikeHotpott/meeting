package self.live.utils;

import self.live.entity.AnswerIdentity;
import self.live.entity.OfferIdentity;

import java.util.ArrayList;
import java.util.List;

public class SignTransferUtil {
    private static List<OfferIdentity> offerIdentityList = new ArrayList<>();
    private static List<AnswerIdentity> answerIdentityList = new ArrayList<>();
    public static void addOfferIdentity(OfferIdentity offerIdentity) {
        String roomName = offerIdentity.getRoomName();
        RoomInfoUtil.findByRoomName(roomName);
        offerIdentityList.add(offerIdentity);
    }
    public static void addAnswerIdentity(AnswerIdentity answerIdentity) {
        String roomName = answerIdentity.getRoomName();
        RoomInfoUtil.findByRoomName(roomName);
        answerIdentityList.add(answerIdentity);
    }
    public static List<OfferIdentity> getNewOffer(String roomName, String id) {
        List<OfferIdentity> offerIdentities = new ArrayList<>();
        for (OfferIdentity offerIdentity : offerIdentityList) {
            if (offerIdentity.getRoomName().equals(roomName) && offerIdentity.getToId().equals(id)) {
                offerIdentities.add(offerIdentity);
            }
        }
        //获取后删掉
        offerIdentityList.removeAll(offerIdentities);
        return offerIdentities;
    }
    public static List<AnswerIdentity> getNewAnswer(String roomName, String id) {
        List<AnswerIdentity> answerIdentities = new ArrayList<>();
        for (AnswerIdentity answerIdentity : answerIdentityList) {
            if (answerIdentity.getRoomName().equals(roomName) && answerIdentity.getToId().equals(id)) {
                answerIdentities.add(answerIdentity);
            }
        }
        answerIdentityList.removeAll(answerIdentities);
        return answerIdentities;
    }
    public static void clear(){
        offerIdentityList.clear();
        answerIdentityList.clear();
    }
}
