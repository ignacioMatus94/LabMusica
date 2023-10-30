package com.example.labmusica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var boton = findViewById<Button>(R.id.boton)

        boton.setOnClickListener {

            val botonNext = Intent(this,Home::class.java)
            startActivity(botonNext)
        }

    }
}