package com.healthylife.alexaskill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import java.util.Optional

class FallbackIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.intentName("FallbackIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val text = "Te puedo ofrecer tres tipos de entrenamientos: básico, intermedio y avanzado. ¿Qué entrenamiento" +
                " te gustaría comenzar?"
        return input.responseBuilder
                .withSpeech(text)
                .withShouldEndSession(false)
                .build()
    }
}