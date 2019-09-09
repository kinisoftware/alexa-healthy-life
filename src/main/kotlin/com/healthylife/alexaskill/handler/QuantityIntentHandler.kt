package com.healthylife.alexaskill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import com.amazon.ask.model.slu.entityresolution.StatusCode
import com.amazon.ask.request.Predicates
import com.google.gson.Gson
import com.healthylife.alexaskill.model.QuantityLevel
import com.healthylife.alexaskill.model.WorkoutLevel
import com.healthylife.alexaskill.model.Workouts
import com.healthylife.alexaskill.utils.Speeches
import java.util.Optional

class QuantityIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.intentName("QuantityIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val request = input.requestEnvelope.request
        val intentRequest = request as IntentRequest
        val intent = intentRequest.intent
        val slots = intent.slots
        val quantityLevelSlot = slots["quantityLevel"]!!

        val quantityLevel = quantityLevelSlot.resolutions.resolutionsPerAuthority
                .first { it.status.code == StatusCode.ER_SUCCESS_MATCH }.values[0].value.id




        val text = when (QuantityLevel.valueOf(quantityLevel)) {
            QuantityLevel.FEW -> Speeches.quantityFew
            QuantityLevel.NORMAL -> Speeches.quantityNormal
            QuantityLevel.MUCH -> Speeches.quantityMuch
        }


        return input.responseBuilder
                .withSpeech(text)
                .withShouldEndSession(true)
                .build()
    }
}