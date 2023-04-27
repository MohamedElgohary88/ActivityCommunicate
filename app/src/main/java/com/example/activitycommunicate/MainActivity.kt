package com.example.activitycommunicate

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.activitycommunicate.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val TAG = "Amna"

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var number = 0
        binding.clickMe.setOnClickListener {
            number++
        }

        binding.navigate.setOnClickListener {
            behaviorSubject.onNext(number)
        }

        behaviorSubject.throttleFirst(1L,TimeUnit.SECONDS).subscribe {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            Log.i(TAG, "navigate")
        }

    }

    companion object {
        val behaviorSubject = BehaviorSubject.create<Int>()
    }
}


