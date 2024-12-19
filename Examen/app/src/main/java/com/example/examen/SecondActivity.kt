package com.example.examen

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.*


class SecondActivity : AppCompatActivity() {
    // Declaro una variable de listas privadas para las preguntas del test
    private val preguntas = listOf(
        Question(
            // Escribo el texto
            text = "¿En qué año se construyó Aula Campus?",
            // Escribo las diferentes respuestas
            answers = listOf("2006", "2020", "1999", "2002"),
            // Selecciono cual es la respuesta correcta
            correctAnswerIndex = 2,
            // Añado una imagen
            imageResId = R.drawable.construccion
        ),
        Question(
            text = "¿Cuál es el color de Aula Campus?",
            answers = listOf("Azul","Rojo","Verde","Amarillo"),
            correctAnswerIndex = 0,
            imageResId = R.drawable.color
        ),
        Question(
            text = "¿Cuál es el objetivo principal de AulaCampus?",
            answers = listOf("Ofrecer formación exclusivamente presencial",
                "Promover la educación gratuita en universidades",
                "Proporcionar una educación accesible y flexible online",
                "Organizar eventos educativos internacionales"),
            correctAnswerIndex = 2,
            imageResId = R.drawable.ayuda
        ),
        Question(
            text = "¿Qué tipo de cursos se pueden encontrar en AulaCampus?",
            answers = listOf("Solamente cursos de idiomas",
                "Solo cursos técnicos",
                "Una variedad de cursos en diferentes áreas",
                "Exclusivamente formación empresarial"),
            correctAnswerIndex = 2,
            imageResId = R.drawable.universidad
        ),
        Question(
            text = "¿A quién está dirigido AulaCampus principalmente?",
            answers = listOf("Exclusivamente a estudiantes universitarios",
                "A cualquier persona interesada en aprender",
                "A empresas multinacionales",
                "A estudiantes de secundaria"),
            correctAnswerIndex = 1,
            imageResId = R.drawable.aprendizaje
        ),
        Question(
            text = "¿Qué idiomas están disponibles para los cursos en AulaCampus?",
            answers = listOf("Solo español","Español e inglés","Más de 10 idiomas","Solo inglés"),
            correctAnswerIndex = 1,
            imageResId = R.drawable.idiomas
        ),
        Question(
            text = "¿Dónde se encuentra el centro de Aula Campus?",
            answers = listOf("Barcelona","Francia","Burjassot","Argentina"),
            correctAnswerIndex = 2,
            imageResId = R.drawable.barcelona
        ),
        Question(
            text = "¿Qué nivel de formación ofrece AulaCampus?",
            answers = listOf("Solo formación básica",
                "Desde nivel básico hasta avanzado",
                "Exclusivamente formación avanzada",
                "Solo formación técnica"),
            correctAnswerIndex = 1,
            imageResId = R.drawable.avance
        ),
        Question(
            text = "¿Cómo se puede pagar un curso en AulaCampus?",
            answers = listOf("Solo con tarjeta de crédito",
                "Diversos métodos de pago, como tarjeta, PayPal y transferencia bancaria ",
                "Únicamente con criptomonedas",
                "Los cursos son totalmente gratuitos"),
            correctAnswerIndex = 1,
            imageResId = R.drawable.pago
        ),
        Question(
            text = "¿Quién es el mejor docente de Aula Campus?",
            answers = listOf("Jose Manuel","Alejandro Palacios","Mario Garcia","Todas las respuestas son correctas"),
            correctAnswerIndex = 3,
            imageResId = R.drawable.profes
        )
    )

    // Creo variables privadas para las preguntas, contador de respuestas correctas
    private var pregunta = 0
    private var puntuacion = 0
    private val respuestas = mutableMapOf<Int, Int>() // Mapa para guardar respuestas seleccionadas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Llamo a las variables del XML
        val questionTextView: TextView = findViewById(R.id.textViewUsuario)
        val radioGroup: RadioGroup = findViewById(R.id.grupoRespuestas)
        val radioButton1: RadioButton = findViewById(R.id.respuesta1)
        val radioButton2: RadioButton = findViewById(R.id.respuesta2)
        val radioButton3: RadioButton = findViewById(R.id.respuesta3)
        val radioButton4: RadioButton = findViewById(R.id.respuesta4)
        val nextButton: Button = findViewById(R.id.botonSiguiente)
        val backButton: Button = findViewById(R.id.botonAnterior)
        val questionImageView: ImageView = findViewById(R.id.questionImageView)

        // Función para cargar una pregunta
        fun loadQuestion(index: Int) {
            val question = preguntas[index]
            questionTextView.text = question.text
            radioButton1.text = question.answers[0]
            radioButton2.text = question.answers[1]
            radioButton3.text = question.answers[2]
            radioButton4.text = question.answers[3]
            radioGroup.clearCheck()

            // Restaurar la selección guardada
            val savedAnswer = respuestas[index]
            if (savedAnswer != null) {
                when (savedAnswer) {
                    0 -> radioButton1.isChecked = true
                    1 -> radioButton2.isChecked = true
                    2 -> radioButton3.isChecked = true
                    3 -> radioButton4.isChecked = true
                }
            }

            // Cambiar la imagen según la pregunta que salga
            if (question.imageResId != null) {
                questionImageView.setImageResource(question.imageResId)
                questionImageView.visibility = ImageView.VISIBLE
            } else {
                questionImageView.visibility = ImageView.GONE // Ocultar si no hay imagen
            }
        }

        // Cargar la primera pregunta
        loadQuestion(pregunta)

        // Configurar botón Siguiente
        nextButton.setOnClickListener {
            val selectedOptionIndex = when (radioGroup.checkedRadioButtonId) {
                R.id.respuesta1 -> 0
                R.id.respuesta2 -> 1
                R.id.respuesta3 -> 2
                R.id.respuesta4 -> 3
                else -> -1
            }

            if (selectedOptionIndex == -1) {
                Toast.makeText(this, "Por favor, selecciona una opción.", Toast.LENGTH_SHORT).show()
            } else {
                // Guardar la respuesta seleccionada
                respuestas[pregunta] = selectedOptionIndex

                // Verificar respuesta si es necesario
                if (selectedOptionIndex == preguntas[pregunta].correctAnswerIndex) {
                    puntuacion++
                }

                // Ir a la siguiente pregunta si es posible
                if (pregunta < preguntas.size - 1) {
                    pregunta++
                    loadQuestion(pregunta)
                } else {
                    questionTextView.text = "¡Cuestionario terminado! Puntuación: $puntuacion/${preguntas.size}"
                    radioGroup.clearCheck()
                    radioButton1.isEnabled = false
                    radioButton2.isEnabled = false
                    radioButton3.isEnabled = false
                    radioButton4.isEnabled = false
                    nextButton.isEnabled = false
                    backButton.isEnabled = false
                }
            }
        }

        // Configurar botón "Atrás"
        backButton.setOnClickListener {
            if (pregunta > 0) {
                pregunta--
                loadQuestion(pregunta)
            } else {
                Toast.makeText(this, "No puedes ir más atrás.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Clase de datos para representar una pregunta
    data class Question(
        val text: String,
        val answers: List<String>,
        val correctAnswerIndex: Int,
        val imageResId: Int
    )
}
