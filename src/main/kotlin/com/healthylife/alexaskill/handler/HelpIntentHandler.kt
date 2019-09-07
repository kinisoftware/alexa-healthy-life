package com.healthylife.alexaskill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import com.healthylife.alexaskill.utils.Speeches
import java.util.Optional

class HelpIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(intentName("AMAZON.HelpIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        return input.responseBuilder
                .withSpeech(Speeches.helper)
                .withReprompt(Speeches.repromptHelper)
                .build()
    }
}
