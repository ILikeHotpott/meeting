package self.live.utils;

import cn.hutool.json.JSONUtil;
import org.springframework.http.HttpStatus;
import self.live.constant.EventEnum;
import self.live.entity.bo.ExceptionBo;
import self.live.entity.bo.SseDataBo;

import java.util.function.Supplier;
public class OvercoatSseExceptionUtil {
    public static String handleException(Supplier<String> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            ExceptionBo exceptionBo = new ExceptionBo(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getMessage()
            );
            String data = JSONUtil.toJsonStr(exceptionBo);
            return new SseDataBo(data, EventEnum.HANDLE_EXCEPTION.getEventName(), "exception").toString();
        }
    }
}
