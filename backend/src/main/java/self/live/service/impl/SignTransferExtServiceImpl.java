package self.live.service.impl;

import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Service;
import self.live.constant.EventEnum;
import self.live.entity.AnswerIdentity;
import self.live.entity.OfferIdentity;
import self.live.entity.bo.SseDataBo;
import self.live.service.SignTransferExtService;
import self.live.utils.SignTransferUtil;

import java.util.List;
@Service
public class SignTransferExtServiceImpl implements SignTransferExtService {
    @Override
    public String getNewOffer(String roomName, String id) {
        List<OfferIdentity> newOffer = SignTransferUtil.getNewOffer(roomName, id);
        String data = JSONUtil.toJsonStr(newOffer);
        return new SseDataBo(data, EventEnum.NEW_OFFER.getEventName(), roomName).toString();
    }

    @Override
    public String getNewAnswer(String roomName, String id) {
        List<AnswerIdentity> newAnswer = SignTransferUtil.getNewAnswer(roomName, id);
        String data = JSONUtil.toJsonStr(newAnswer);
        return new SseDataBo(data, EventEnum.MEW_ANSWER.getEventName(), roomName).toString();
    }
}
