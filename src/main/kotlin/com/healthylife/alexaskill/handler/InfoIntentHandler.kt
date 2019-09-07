package com.healthylife.alexaskill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import com.amazon.ask.model.slu.entityresolution.StatusCode
import com.amazon.ask.request.Predicates
import com.google.gson.Gson
import com.healthylife.alexaskill.model.WorkoutLevel
import com.healthylife.alexaskill.model.Workouts
import java.util.Optional

class InfoIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.intentName(" InfoIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        val request = input.requestEnvelope.request
        val intentRequest = request as IntentRequest
        val intent = intentRequest.intent
        val slots = intent.slots
        val workoutLevelSlot = slots["workoutLevel"]!!

        val workoutLevelId = workoutLevelSlot.resolutions.resolutionsPerAuthority
                .first { it.status.code == StatusCode.ER_SUCCESS_MATCH }.values[0].value.id
        val workoutLevelName = workoutLevelSlot.resolutions.resolutionsPerAuthority
                .first { it.status.code == StatusCode.ER_SUCCESS_MATCH }.values[0].value.name


        val workoutsRepository = """
            {
            "basic":["Sentadillas intercaladas","Planchas con apoyo de codos","Correr en el sitio","Flexiones brazo hacia pies"],
            "medium":["Plancha empleando brazos verticales","Zancadas hacia atrás","Zancadas hacia adelante","Flexiones codos a la rodilla"],
            "advance":["Torsión del Tórax hacia el lado derecho","Torsión del Tórax hacia el llado izquierdo","Tumbarse en el suelo, y estirar piernas intercalados","Plancha lateral"]
            }
            """.trimIndent()

        val workouts = Gson().fromJson(workoutsRepository, Workouts::class.java)
        val exercises = when (WorkoutLevel.valueOf(workoutLevelId)) {
            WorkoutLevel.BASIC -> workouts.basic
            WorkoutLevel.INTERMEDIATE -> workouts.medium
            WorkoutLevel.ADVANCED -> workouts.advance
        }.joinToString(",")

        val text = "Los ejercicios del nivel $workoutLevelName son: $exercises"
        return input.responseBuilder
                .withSpeech(text)
                .withShouldEndSession(true)
                .build()
    }
}