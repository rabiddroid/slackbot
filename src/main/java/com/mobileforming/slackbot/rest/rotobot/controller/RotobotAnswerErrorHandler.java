package com.mobileforming.slackbot.rest.rotobot.controller;

import com.mobileforming.slackbot.rest.rotobot.error.RotobotAnswerAuthenticationFailure;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jeffreypthomas on 9/16/15.
 */
@ControllerAdvice public class RotobotAnswerErrorHandler {

    private static final org.slf4j.Logger LOG =
        org.slf4j.LoggerFactory.getLogger(RotobotAnswerErrorHandler.class);

    @ResponseBody @ExceptionHandler(RotobotAnswerAuthenticationFailure.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public VndErrors authenticationErrorHandler(RotobotAnswerAuthenticationFailure error) {

        return new VndErrors("error", error.getMessage());

    }

}
