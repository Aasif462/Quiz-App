package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

//class MainActivity : AppCompatActivity() , View.OnClickListener {
//
//    private lateinit var questions:TextView
//    private lateinit var progressBar: ProgressBar
//    private lateinit var passedQna:TextView
//    private lateinit var op1:Button
//    private lateinit var op2:Button
//    private lateinit var op3:Button
//    private lateinit var op4:Button
//    private lateinit var submit:Button
//    private var currentPosition:Int = 1
//    private lateinit var questionList:ArrayList<Question>
//    private var optionSelectedPosition = 0
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        questions = findViewById(R.id.questions)
//        progressBar = findViewById(R.id.progressBar)
//        passedQna = findViewById(R.id.passedQna)
//        op1 = findViewById(R.id.optionOne)
//        op2 = findViewById(R.id.optionTwo)
//        op3 = findViewById(R.id.optionThree)
//        op4 = findViewById(R.id.optionFour)
//        submit = findViewById(R.id.submit)
//
//
//        op1.setOnClickListener(this)
//        op2.setOnClickListener(this)
//        op3.setOnClickListener(this)
//        op4.setOnClickListener(this)
//
//        questionList = Constants.getQuestions()
//        setQuestion()
//
//    }
//
//    @SuppressLint("SetTextI18n")
//    fun setQuestion() {
//        val question:Question = questionList[currentPosition- 1]
//        progressBar.progress = currentPosition
//        passedQna.text = "$currentPosition/${progressBar.max}"
//        questions.text = question.question
//        op1.text = question.one
//        op2.text = question.two
//        op3.text = question.three
//        op4.text = question.four
//
//    }
//
//    private fun defaultOptionView(){
//        val options = ArrayList<Button>()
//        op1.let {
//            options.add(0 , it)
//        }
//
//        op2.let {
//            options.add(1 , it)
//        }
//
//        op3.let {
//            options.add(2 , it)
//        }
//
//        op4.let {
//            options.add(3 , it)
//        }
//
//        for(option in options){
//            option.setTextColor(Color.parseColor("#000000"))
//            option.typeface = Typeface.DEFAULT
//            option.setBackgroundColor(Color.parseColor("#FFFFFF"))
//        }
//
//    }
//
//    private fun selectedOption(tv:TextView, selectedOption:Int){
//        defaultOptionView()
//        optionSelectedPosition = selectedOption
//        tv.setTextColor(Color.parseColor("#FFFFFF"))
//        tv.typeface = Typeface.DEFAULT_BOLD
//        tv.setBackgroundColor(Color.parseColor("#FF3700B3"))
//    }
//
//    override fun onClick(view: View?) {
//        when (view?.id) {
//            R.id.optionOne -> {
//                selectedOption(op1, 1)
//            }
//            R.id.optionTwo -> {
//                selectedOption(op2, 2)
//            }
//            R.id.optionThree -> {
//                selectedOption(op3, 3)
//            }
//            R.id.optionFour -> {
//                selectedOption(op4, 4)
//            }
//
//            R.id.submit ->{
//                if(optionSelectedPosition != 0){
//
//                    val question = questionList[currentPosition-1]
//                    if(question.correctAnswer != optionSelectedPosition){
//                        answerView(optionSelectedPosition , R.drawable.wrong_background)
//                    }
//                    answerView(optionSelectedPosition , R.drawable.right_backgroud)
//                    if(currentPosition == questionList.size){
//                        submit.text = "Finish"
//                    }
//                    else
//                        submit.text = "Next"
//
//                    optionSelectedPosition = 0
//
//
//                }
//                else{
//                    currentPosition++
//
//                    when{
//                        currentPosition <= questionList.size ->
//                        {
//                            setQuestion()
//                        }
//                    }
//                }
//            }
//        }
//    }
//    private fun answerView(answer:Int, drawableView:Int){
//        when(answer){
//            1 -> {
//                op1.background = ContextCompat.getDrawable(this , drawableView)
//            }
//
//            2 ->{
//                op2.background = ContextCompat.getDrawable(this , drawableView)
//            }
//
//            3 ->
//            {
//                op3.background = ContextCompat.getDrawable(this , drawableView)
//            }
//
//            4 ->
//            {
//                op4.background = ContextCompat.getDrawable(this , drawableView)
//            }
//        }
//    }
//}


class MainActivity : AppCompatActivity() {

    private var Name:String?=null
    private var score:Int=0
    private lateinit var op1:Button
    private lateinit var op2:Button
    private lateinit var op3:Button
    private lateinit var op4:Button
    private lateinit var submit:Button
    private lateinit var progressBar: ProgressBar
    private lateinit var questions:TextView
    private lateinit var passedQna:TextView

    private var currentPosition:Int=1
    private var questionList:ArrayList<Question> ? = null
    private var selecedOption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Name=intent.getStringExtra(setData.name)


        questionList=Constants.getQuestions()

        setQuestion()

        op1.setOnClickListener{

            selectedOptionStyle(op1,1)
        }
        op2.setOnClickListener{

            selectedOptionStyle(op2,2)
        }
        op3.setOnClickListener{

            selectedOptionStyle(op3,3)
        }
        op4.setOnClickListener{

            selectedOptionStyle(op4,4)
        }

        submit.setOnClickListener {
            if(selecedOption!=0)
            {
                val question=questionList!![currentPosition-1]
                if(selecedOption!=question.correctAnswer)
                {
                    setColor(selecedOption,R.drawable.wrong_background)
                }else{
                    score++;
                }
                setColor(question.correctAnswer,R.drawable.right_backgroud)
                if(currentPosition==questionList!!.size)
                    submit.text="FINISH"
                else
                    submit.text="Go to Next"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
//                    else->{
//                        var intent= Intent(this,Result::class.java)
//                        intent.putExtra(Constants.name,Name.toString())
//                        intent.putExtra(Constants.score,score.toString())
//                        intent.putExtra("total size",questionList!!.size.toString())
//
//                        startActivity(intent)
//                        finish()
//                    }
                }
            }
            selecedOption=0
        }

    }

    private fun setColor(opt:Int, color:Int){
        when(opt){
            1->{
                op1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                op2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                op3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                op4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }


    private fun setQuestion(){

        val question = questionList!![currentPosition-1]
        setOptionStyle()


        progressBar.progress=currentPosition
        progressBar.max=questionList!!.size
        passedQna.text="${currentPosition}"+"/"+"${questionList!!.size}"
        questions.text=question.question
        op1.text=question.one
        op2.text=question.two
        op3.text=question.three
        op4.text=question.four

    }

    private fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,op1)
        optionList.add(1,op2)
        optionList.add(2,op3)
        optionList.add(3,op4)

        for(option in optionList){
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

    private fun selectedOptionStyle(view:TextView, opt:Int){

        setOptionStyle()
        selecedOption = opt
        view.setTextColor(Color.parseColor("#FFFFFF"))
        view.typeface = Typeface.DEFAULT_BOLD
        view.setBackgroundColor(Color.parseColor("#FF3700B3"))

    }
}