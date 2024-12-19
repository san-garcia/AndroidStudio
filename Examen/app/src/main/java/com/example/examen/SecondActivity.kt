package com.example.examen

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.*

class SecondActivity : AppCompatActivity() {
    private val questions = listOf(
        Question(
            text = "¿En qué año se construyó Aula Campus?",
            answers = listOf("2006", "2020", "1999", "2002"),
            correctAnswerIndex = 2,
            imageResId = R.drawable.construccion
        ),
        Question(
            text = "¿Cuál es el color de Aula Campus?",
            answers = listOf("Azul", "Rojo", "Verde", "Amarillo"),
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
            answers = listOf("Solo español",
                "Español e inglés",
                "Más de 10 idiomas",
                "Solo inglés"),
            correctAnswerIndex = 1,
            imageResId = R.drawable.idiomas
        ),
        Question(
            text = "¿Dónde se encuentra el centro de Aula Campus?",
            answers = listOf("Barcelona",
                "Francia",
                "Burjassot",
                "Argentina"),
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
                "Los cursos son gratuitos"),
            correctAnswerIndex = 1,
            imageResId = R.drawable.pago
        ),
        Question(
            text = "¿Quién es el mejor docente de Aula Campus?",
            answers = listOf("Jose Manuel",
                "Alejandro Palacios",
                "Mario Garcia",
                "Todas las respuestas son correctas"),
            correctAnswerIndex = 3,
            imageResId = R.drawable.profes
        )
    )

    private var currentQuestionIndex = 0
    private var score = 0
    private val selectedAnswers = mutableMapOf<Int, Int>() // Mapa para guardar respuestas seleccionadas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val questionTextView: TextView = findViewById(R.id.textView)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val radioButton1: RadioButton = findViewById(R.id.radioButton)
        val radioButton2: RadioButton = findViewById(R.id.radioButton2)
        val radioButton3: RadioButton = findViewById(R.id.radioButton3)
        val radioButton4: RadioButton = findViewById(R.id.radioButton4)
        val nextButton: Button = findViewById(R.id.buttonNext)
        val backButton: Button = findViewById(R.id.buttonBack)
        val questionImageView: ImageView = findViewById(R.id.questionImageView)

        // Función para cargar una pregunta
        fun loadQuestion(index: Int) {
            val question = questions[index]
            questionTextView.text = question.text
            radioButton1.text = question.answers[0]
            radioButton2.text = question.answers[1]
            radioButton3.text = question.answers[2]
            radioButton4.text = question.answers[3]
            radioGroup.clearCheck()

            // Restaurar la selección guardada (si existe)
            val savedAnswer = selectedAnswers[index]
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
        loadQuestion(currentQuestionIndex)

        // Configurar botón "Siguiente"
        nextButton.setOnClickListener {
            val selectedOptionIndex = when (radioGroup.checkedRadioButtonId) {
                R.id.radioButton -> 0
                R.id.radioButton2 -> 1
                R.id.radioButton3 -> 2
                R.id.radioButton4 -> 3
                else -> -1
            }

            if (selectedOptionIndex == -1) {
                Toast.makeText(this, "Por favor, selecciona una opción.", Toast.LENGTH_SHORT).show()
            } else {
                // Guardar la respuesta seleccionada
                selectedAnswers[currentQuestionIndex] = selectedOptionIndex

                // Verificar respuesta si es necesario
                if (selectedOptionIndex == questions[currentQuestionIndex].correctAnswerIndex) {
                    score++
                }

                // Ir a la siguiente pregunta si es posible
                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                    loadQuestion(currentQuestionIndex)
                } else {
                    questionTextView.text = "¡Cuestionario terminado! Puntuación: $score/${questions.size}"
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
            if (currentQuestionIndex > 0) {
                currentQuestionIndex--
                loadQuestion(currentQuestionIndex)
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
