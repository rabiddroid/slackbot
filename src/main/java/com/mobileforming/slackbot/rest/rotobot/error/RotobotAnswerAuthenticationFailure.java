package com.mobileforming.slackbot.rest.rotobot.error;

/**
 * Created by jeffreypthomas on 9/16/15.
 */
public class RotobotAnswerAuthenticationFailure extends RuntimeException {



    private static final org.slf4j.Logger LOG =
        org.slf4j.LoggerFactory.getLogger(RotobotAnswerAuthenticationFailure.class);



    public RotobotAnswerAuthenticationFailure(String s) {
        super(s);
    }
}
