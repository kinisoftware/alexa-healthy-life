package com.healthylife.alexaskill.utils

class Speeches {
    companion object {
        const val welcome = """
            <audio src="https://alexa-healthy-life.s3-eu-west-1.amazonaws.com/speechAudios/intro.mp3"/>¡<prosody volume="x-loud"><say-as interpret-as="interjection">hola</say-as></prosody>!<break time="100ms"/> Gracias por elegir vida saludable, le vamos a ayudar a mantenerse en forma. Tenemos tres niveles disponibles: básico, intermedio, avanzado. ¿Por cuál te gustaría empezar?
            """
        const val repromptWelcome = "Puedes pedirme comenzar por un entrenamiento."
        const val helper = "¿Qué entrenamiento quieres realizar?"
        const val repromptHelper ="Podemos realizar un entrenamiento básico, medio o avanzado."
        const val startExercice = """ 
             <prosody volume="x-loud">5...4...3..2...1....</prosody>
             """

        const val exerciceCounter = """ 
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><break strength="none"/>
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><break strength="none"/>
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><break strength="none"/>
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><break strength="none"/>
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><prosody volume="soft">5...4...3...2...1....</prosody>
                """
        const val lastExerciseCounter = """
             <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><break strength="none"/>
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><break strength="none"/>
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><break strength="none"/>
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/><break strength="none"/>
                <audio src="soundbank://soundlibrary/clocks/ticks/ticks_10"/>
                <prosody volume="soft">5...4...3...2...1....</prosody>
                <prosody volume="x-loud">¡Terminamos!</prosody>"
             """

        const val breakCounter = """
                <break time="5s"/><prosody volume="x-loud">5...4...3...2...1....</prosody>
                """

        const val goodbye =  """
                    ¡<say-as interpret-as="interjection">gracias</say-as> por usar vida saludable!<say-as interpret-as="interjection">hasta luego</say-as>!
                """

    }
}