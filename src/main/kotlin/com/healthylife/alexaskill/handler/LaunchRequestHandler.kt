package com.healthylife.alexaskill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import java.util.Optional

class LaunchRequestHandler : RequestHandler {

    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.requestType(LaunchRequest::class.java))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val repromptText = "¿Qué tipo de entrenamiento te gustaría hacer?"
        val text = "¡Hola! Gracias por elegir vida saludable, le vamos a ayudar a mantenerse en forma. " +
                "Tenemos tres niveles disponibles: básico, intermedio, avanzado. ¿Por cuál te gustaría empezar?"
        return input.responseBuilder
                .withSpeech(text)
                .withReprompt(repromptText)
                .build()
    }
}