package com.example.labmusica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        var boton = findViewById<Button>(R.id.backButton)

        boton.setOnClickListener {

            val botonMusic = Intent(this,Audio::class.java)
            startActivity(botonMusic)
        }




    }
}