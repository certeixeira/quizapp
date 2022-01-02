package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Suriname",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "United States",
            "Brazil",
            2
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Germany",
            "France",
            "Brazil",
            1
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belgium",
            "Argentina",
            "Peru",
            "Brazil",
            4
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Belgium",
            "Japan",
            "Denmark",
            "Netherlands",
            3
        )
        questionsList.add(que5)

        val que6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Australia",
            "Fiji",
            "Japan",
            "Finland",
            2
        )
        questionsList.add(que6)

        val que7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Belgiun",
            "Netherlands",
            "Finland",
            1
        )
        questionsList.add(que7)

        val que8 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Australia",
            "Fiji",
            "India",
            "Finland",
            3
        )
        questionsList.add(que8)

        val que9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Vatican",
            "Fiji",
            "Brazil",
            "Kuait",
            4
        )
        questionsList.add(que9)

        val que10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "England",
            "Australia",
            "Scotland",
            1
        )
        questionsList.add(que10)


        return questionsList
    }
}