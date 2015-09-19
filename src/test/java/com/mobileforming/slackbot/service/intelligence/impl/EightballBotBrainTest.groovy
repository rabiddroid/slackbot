package com.mobileforming.slackbot.service.intelligence.impl

import org.springframework.util.Assert

/**
 * Created by jeffreypthomas on 9/16/15.
 */
class EightballBotBrainTest extends spock.lang.Specification {

    def "FindAnswer"() {

        setup: def botBrain = new EightballBotBrain();

        when:
        String answer = botBrain.findAnswer("","Am I going to bed early tonight");

        then:
        Assert.hasText(answer);



    }

    def "FindAnswerWhenEmptyQuestion"(){

        setup: def botBrain = new EightballBotBrain();

        when:
        String answerForEmpty = botBrain.findAnswer("","");
        String answerForNull = botBrain.findAnswer("",null);

        then:
        "Concentrate and ask again".equals(answerForEmpty);
        "Concentrate and ask again".equals(answerForNull)
    }
}
