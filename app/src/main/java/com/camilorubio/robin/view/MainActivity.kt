package com.camilorubio.robin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.camilorubio.robin.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}