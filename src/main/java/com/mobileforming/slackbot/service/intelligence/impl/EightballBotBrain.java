package com.mobileforming.slackbot.service.intelligence.impl;

import com.google.common.base.Strings;
import com.mobileforming.slackbot.service.intelligence.BotBrain;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by jeffreypthomas on 9/16/15.
 */
@Component
public class EightballBotBrain implements BotBrain {

    private static final org.slf4j.Logger LOG =
        org.slf4j.LoggerFactory.getLogger(EightballBotBrain.class);

    private static final String[] CLASSIC_ANSWERS;
    private static final String ANSWER_TO_EMPTY_QUESTION;

    static {
        CLASSIC_ANSWERS =
            new String[] {"As I see it, Yes", "Don't count on it", "Reply hazy, ask again",
                "It is certain", "My reply is no", "Ask again later", "It is decidely so",
                "My sources say no", "Better not tell you now", "Most likely",
                "Outlook not so good", "Cannot predict now", "Outlook good", "Very doubtful",
                "Concentrate and ask again", "Signs point to yes", "Without a doubt", "Yes",
                "Yes, definitely", "You may rely on it"};
        ANSWER_TO_EMPTY_QUESTION = "Concentrate and ask again";
    }

    private final int minRandomValue;
    private final int maxRandomValue;

    public EightballBotBrain() {
        this(0, CLASSIC_ANSWERS.length - 1);
    }

    public EightballBotBrain(int minRandomValue, int maxRandomValue) {
        Assert.isTrue(minRandomValue >= 0 && minRandomValue < CLASSIC_ANSWERS.length,"Random min value not within bounds");
        Assert.isTrue(maxRandomValue >= 0 && minRandomValue < CLASSIC_ANSWERS.length,"Random max value not within bounds");

        this.minRandomValue = minRandomValue;
        this.maxRandomValue = maxRandomValue;
    }

    @Override public String findAnswer(String replyTo, String formattedQuestion) {

        final String answer;
        if (Strings.isNullOrEmpty(formattedQuestion)) {
            answer = ANSWER_TO_EMPTY_QUESTION;
        } else {
            answer = CLASSIC_ANSWERS[getRandomInteger()];
        }

        return answer;
    }

    private int getRandomInteger() {
        return ThreadLocalRandom.current().nextInt(minRandomValue, maxRandomValue + 1);
    }
}
