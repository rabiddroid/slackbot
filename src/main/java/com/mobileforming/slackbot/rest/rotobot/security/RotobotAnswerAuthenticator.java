package com.mobileforming.slackbot.rest.rotobot.security;

import com.mobileforming.slackbot.rest.rotobot.error.RotobotAnswerAuthenticationFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by jeffreypthomas on 9/16/15.
 */
@Component
public class RotobotAnswerAuthenticator {

    private static final org.slf4j.Logger LOG =
        org.slf4j.LoggerFactory.getLogger(RotobotAnswerAuthenticator.class);


    private final String authToken;

    @Autowired
    public RotobotAnswerAuthenticator(@Value("${slack.rotobot.authToken}")String authToken) {
        Assert.hasText(authToken);
        this.authToken = authToken;
    }

    public void validateToken(String token) {

        if (!authToken.equals(token)) {
            throw new RotobotAnswerAuthenticationFailure(String.format("Invalid token {%s} supplied",token));
        }

    }
}
