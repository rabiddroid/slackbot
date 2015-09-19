package com.mobileforming.slackbot.rest.rotobot.service;

import com.mobileforming.slackbot.rest.model.rotobot.RotobotAnswer;
import com.mobileforming.slackbot.service.intelligence.BotBrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeffreypthomas on 9/16/15.
 */
@Service
public class RotoBotService {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(RotoBotService.class);
    private static final java.lang.String BOT_NAME = "rotobot:";
    private final BotBrain brain;


    @Autowired
    public RotoBotService(BotBrain brain) {
        this.brain = brain;
    }

    public RotobotAnswer reply(String replyTo, String question) {

        final String formattedQuestion = extractQuestion(question);
        String answer = brain.findAnswer(replyTo,formattedQuestion);

        return new RotobotAnswer(answer);

    }

    /*Package private*/ static String extractQuestion(String text) {
        String question = text.trim();
        if (question.startsWith(BOT_NAME)) {
            question = question.substring(BOT_NAME.length(), question.length());
        }

        return question;
    }
}
