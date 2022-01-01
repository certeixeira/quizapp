package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionList = Constants.getQuestions()
        Log.i("Question Size", "${questionList.size}")

        val currentPosition = 1
        val question: Question? = questionList[currentPosition -1]

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        progressBar.progress = currentPosition
        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        tvProgress.text = "$currentPosition" + "/" + progressBar.max
        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        tvQuestion.text = question!!.question
        val ivImage = findViewById<ImageView>(R.id.iv_image)
        ivImage.setImageResource(question.image)

        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)
        val optionFour = findViewById<TextView>(R.id.tv_option_four)

        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour
    }
}