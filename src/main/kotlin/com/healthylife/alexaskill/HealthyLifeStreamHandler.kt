package com.healthylife.alexaskill

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.healthylife.alexaskill.handler.*
import com.healthylife.alexaskill.interceptor.LogRequestInterceptor
import com.healthylife.alexaskill.interceptor.LogResponseInterceptor

class HealthyLifeStreamHandler : SkillStreamHandler(skill) {
    companion object {
        private val skill = Skills.standard()
                .addRequestInterceptor(LogRequestInterceptor())
                .addResponseInterceptor(LogResponseInterceptor())
                .addRequestHandlers(
                        LaunchRequestHandler(),
                        HelpIntentHandler(),
                        CancelAndStopIntentHandler(),
                        WorkoutIntentHandler(),
                        QuantityIntentHandler(),
                        SessionEndedRequestHandler()
                ).build()
    }
}
