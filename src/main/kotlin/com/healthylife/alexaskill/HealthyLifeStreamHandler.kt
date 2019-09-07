package com.healthylife.alexaskill

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.healthylife.alexaskill.handler.CancelAndStopIntentHandler
import com.healthylife.alexaskill.handler.HelpIntentHandler
import com.healthylife.alexaskill.handler.LaunchRequestHandler
import com.healthylife.alexaskill.handler.SessionEndedRequestHandler
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
                        SessionEndedRequestHandler()
                ).build()
    }
}
