package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class IntroScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screen)

        val name:EditText = findViewById(R.id.name)
        val start: Button = findViewById(R.id.startbtn)

        start.setOnClickListener{

            if(name.text.toString().isNotEmpty())
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
                Toast.makeText(this , "Please Enter Name" , Toast.LENGTH_SHORT).show()

        }
    }
}