package com.example.quizapp

object Constants {

    fun getQuestions():ArrayList<Question>{
        val questions = ArrayList<Question>()

        val que1 = Question(
            1, "Which of the following is not a Java features?" , "Dynamic" ,
            "Architecture Neutral" , "Use of pointers" , "Object-oriented"
        , 2
        )

        val que2 = Question(
            2 , "_____ is used to find and fix bugs in the Java programs."
        ,"JVM" , "JRE" , "JDK" , "JDB",3
        )

        val que3 = Question(
            3 , "Which of the following is a valid declaration of a char?"
        ,"char ch = '\\utea';" , "char ca = 'tea';" , "char cr = \\u0223;" , "char cc = '\\itea';" , 0
        )

        val que4 = Question(
            4 , "What is the return type of the hashCode() method in the Object class?" ,
            "Object" , "int" , "long" , "void" , 1
        )

        val que5 = Question(
            5 , "Which of the following is a valid long literal?"
        ,"ABH8097" , "L990023" , "904423" , "0xnf029L" ,3
        )

        val que6 = Question(
            6 , "What does the expression float a = 35 / 0 return?"
        ,"0" , "Not a Number" , "Infinity" , "Run time exception" , 2
        )

        questions.add(que1)
        questions.add(que2)
        questions.add(que3)
        questions.add(que4)
        questions.add(que5)
        questions.add(que6)

        return questions
    }
}