package com.extensions.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pulse.sdk.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showToast("Some Toast")
    }
}