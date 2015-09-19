package com.mobileforming.slackbot.rest.model.rotobot;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jeffreypthomas on 9/16/15.
 */
public class RotobotAnswer {

    private static final org.slf4j.Logger LOG =
        org.slf4j.LoggerFactory.getLogger(RotobotAnswer.class);

    @JsonProperty("text") private String text;

    public RotobotAnswer(String answer) {

        this.text = answer != null ? answer.trim() : "";

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
