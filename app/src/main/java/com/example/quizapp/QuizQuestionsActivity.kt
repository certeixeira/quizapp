package com.example.quizapp

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        val optionOne: TextView = findViewById(R.id.tv_option_one)
        val optionTwo: TextView = findViewById(R.id.tv_option_two)
        val optionThree: TextView = findViewById(R.id.tv_option_three)
        val optionFour: TextView = findViewById(R.id.tv_option_four)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
    }


    private fun setQuestion() {
        val optionOne: TextView = findViewById(R.id.tv_option_one)
        val optionTwo: TextView = findViewById(R.id.tv_option_two)
        val optionThree: TextView = findViewById(R.id.tv_option_three)
        val optionFour: TextView = findViewById(R.id.tv_option_four)
        mCurrentPosition = 1
        val question = mQuestionList!![mCurrentPosition - 1]

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        progressBar.progress = mCurrentPosition
        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max
        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        tvQuestion.text = question!!.question
        val ivImage = findViewById<ImageView>(R.id.iv_image)
        ivImage.setImageResource(question.image)

        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val optionOne: TextView = findViewById(R.id.tv_option_one)
        val optionTwo: TextView = findViewById(R.id.tv_option_two)
        val optionThree: TextView = findViewById(R.id.tv_option_three)
        val optionFour: TextView = findViewById(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)
        options.add(3, optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        val optionOne: TextView = findViewById(R.id.tv_option_one)
        val optionTwo: TextView = findViewById(R.id.tv_option_two)
        val optionThree: TextView = findViewById(R.id.tv_option_three)
        val optionFour: TextView = findViewById(R.id.tv_option_four)
        when(v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(optionOne, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(optionTwo, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(optionThree, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(optionFour, 4)
            }
        }
    }

    private fun selectedOptionView(
        tv: TextView,
        selectedOptionNum: Int) {

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

}