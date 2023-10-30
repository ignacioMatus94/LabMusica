package com.example.labmusica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var boton = findViewById<Button>(R.id.music)

        boton.setOnClickListener {

            val botonMusic = Intent(this,Audio::class.java)
            startActivity(botonMusic)
        }


        var boton2 = findViewById<Button>(R.id.about)

        boton2.setOnClickListener {

            val botonAbout = Intent(this,About::class.java)
            startActivity(botonAbout)
        }


    }
}