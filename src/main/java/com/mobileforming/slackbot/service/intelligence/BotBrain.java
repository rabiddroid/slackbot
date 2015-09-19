package com.mobileforming.slackbot.service.intelligence;

/**
 * Created by jeffreypthomas on 9/16/15.
 */
public interface BotBrain {


    String findAnswer(String replyTo, String formattedQuestion);
}
