package com.sovava.video.advice;

import com.sovava.common.utils.R;
import com.sovava.video.enums.ReturnCodeEnums;
import com.sovava.video.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class VideoControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public R handlerUserNotFound(UserNotFoundException e) {
        return R.error(ReturnCodeEnums.USER_NOT_FIND.getCode(), ReturnCodeEnums.USER_NOT_FIND.getMsg()).setData(e.getMessage());
    }
}
