package com.mobileforming.slackbot.rest.rotobot.controller;


import com.mobileforming.slackbot.rest.model.rotobot.RotobotAnswer;
import com.mobileforming.slackbot.rest.rotobot.security.RotobotAnswerAuthenticator;
import com.mobileforming.slackbot.rest.rotobot.service.RotoBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by jeffreypthomas on 9/16/15.
 */

@RestController public class RotobotAnswerController {

    private static final org.slf4j.Logger LOG =
        org.slf4j.LoggerFactory.getLogger(RotobotAnswerController.class);


    private final RotobotAnswerAuthenticator authenticator;
    private final RotoBotService rotoBotService;

    @Autowired public RotobotAnswerController(RotobotAnswerAuthenticator authenticator,
        RotoBotService rotoBotService) {
        this.authenticator = authenticator;
        this.rotoBotService = rotoBotService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rotobot/answer") @ResponseBody
    public RotobotAnswer getAnAnswer(@RequestParam MultiValueMap<String,String> request) throws IOException {

        /*final ServletInputStream inputStream = request.getInputStream();
        final Map<String, String[]> parameterMap = request.getParameterMap();



        String theString = IOUtils.toString(inputStream, "UTF-8");
        IOUtils.closeQuietly(inputStream);

        LOG.info("<----------------NEXT REQUEST---------------->");
        for (Map.Entry<String, String[]> mapEntry : parameterMap.entrySet()) {
            LOG.info(String.format("Parameters received -> [%s]=%s", mapEntry.getKey(),
                Joiner.on(",").join(mapEntry.getValue())));
        }

        LOG.info("Raw Data received -> {}", theString);

        return new RotobotAnswer("TEst");

*/
        final String authenticationToken = request.getFirst("token");
        authenticator.validateToken(authenticationToken);


        final String replyTo = request.getFirst("user_name");
        final String question = request.getFirst("text");
        return rotoBotService.reply(replyTo, question);


    }

}
