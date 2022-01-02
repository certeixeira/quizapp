package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        val optionOne: TextView = findViewById(R.id.tv_option_one)
        val optionTwo: TextView = findViewById(R.id.tv_option_two)
        val optionThree: TextView = findViewById(R.id.tv_option_three)
        val optionFour: TextView = findViewById(R.id.tv_option_four)
        val btnSubmit: Button = findViewById(R.id.btn_submit)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

    }


    private fun setQuestion() {
        val optionOne: TextView = findViewById(R.id.tv_option_one)
        val optionTwo: TextView = findViewById(R.id.tv_option_two)
        val optionThree: TextView = findViewById(R.id.tv_option_three)
        val optionFour: TextView = findViewById(R.id.tv_option_four)
        val btnSubmit: Button = findViewById(R.id.btn_submit)

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }

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
        val btnSubmit: Button = findViewById(R.id.btn_submit)
        when (v?.id) {
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
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)

                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        val optionOne: TextView = findViewById(R.id.tv_option_one)
        val optionTwo: TextView = findViewById(R.id.tv_option_two)
        val optionThree: TextView = findViewById(R.id.tv_option_three)
        val optionFour: TextView = findViewById(R.id.tv_option_four)
        val btnSubmit: Button = findViewById(R.id.btn_submit)
        when (answer) {
            1 -> {
                optionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(
        tv: TextView,
        selectedOptionNum: Int
    ) {

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