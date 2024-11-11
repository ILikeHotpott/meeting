package self.live.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import self.live.entity.bo.ExceptionBo;
import self.live.exception.LiveException;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(LiveException.class)
    public ExceptionBo handleBizException(LiveException e) {
        return new ExceptionBo(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        );
    }
}
