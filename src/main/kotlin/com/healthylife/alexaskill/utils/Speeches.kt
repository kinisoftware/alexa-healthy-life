package com.healthylife.alexaskill.utils

class Speeches {
    companion object {
        const val welcome = """
            <audio src="https://alexa-healthy-life.s3-eu-west-1.amazonaws.com/speechAudios/intro.mp3"/>
            ¡<prosody volume="x-loud"><say-as interpret-as="interjection">hola</say-as></prosody>!
            <break time="50ms"/> 
            Bienvenido a vida saludable, voy a ayudarte a mantenerte en forma. Tengo 
            tres niveles disponibles de ejercicio: básico, intermedio y avanzado. ¿Por cuál te gustaría comenzar?
            """
        const val repromptWelcome = "Puedes pedirme comenzar por un entrenamiento."
        const val helper = "¿Qué entrenamiento quieres realizar? Tengo disponibles los niveles básico, medio y avanzado"
        const val repromptHelper ="Podemos realizar un entrenamiento básico, medio o avanzado."
        const val startExercice = """ 
             <prosody volume="x-loud">en 5...4...3...2...1...</prosody>
             """

        const val exerciceCounter = """
                <audio src="https://alexa-healthy-life.s3-eu-west-1.amazonaws.com/speechAudios/clocks_concat.mp3"/>
                <prosody volume="soft">5...4...3...2...1...</prosody>
                <prosody volume="x-loud">¡Descansamos!</prosody>"
                """
        const val exerciceCounter2 = """
                <audio src="https://alexa-healthy-life.s3-eu-west-1.amazonaws.com/speechAudios/clocks_concat.mp3"/>
                <prosody volume="x-loud">¡Descansamos en!</prosody>"
                <prosody volume="soft">5...4...3...2...1...</prosody>
                """
        const val lastExerciseCounter = """
                <audio src="https://alexa-healthy-life.s3-eu-west-1.amazonaws.com/speechAudios/clocks_concat.mp3"/>
                <prosody volume="soft">5...4...3...2...1....</prosody>
                <prosody volume="x-loud">¡Terminamos el entrenamiento!</prosody>"
             """

        const val breakCounter = """
                <break time="5s"/><prosody volume="x-loud">5...4...3...2...1...</prosody>
                """
        const val quantityFew =  """
                    Entonces te recomiendo un entrenamiento básico.
                """
        const val quantityNormal =  """
                    <say-as interpret-as="interjection">hmm</say-as> Puedes realizar un entrenamiento normal.
                """

        const val quantityMuch =  """
                    <say-as interpret-as="interjection">ah</say-as> Entonces te recomiendo un entrenamiento avanzado.
                """


        const val goodbye =  """
                    ¡<say-as interpret-as="interjection">gracias</say-as> por usar vida saludable!<say-as interpret-as="interjection">hasta luego</say-as>!
                """

    }
}