package com.example.activitycommunicate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.activitycommunicate.MainActivity.Companion.behaviorSubject

class SecondActivity : AppCompatActivity() {
    lateinit var textNumber: TextView

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textNumber = findViewById(R.id.text_number)

        behaviorSubject.subscribe {
            textNumber.text = it.toString()
        }
    }
}