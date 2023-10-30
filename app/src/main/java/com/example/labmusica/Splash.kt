package com.example.labmusica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.ImageView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Getting preference
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        // Read a preference
        val valor = sharedPreferences.getString("splash_time", "3000")


        // Load the fade-in animation
        val fadeIn = AnimationUtils.loadAnimation(applicationContext, R.anim.fadein)

        // Load the growth animation
        val scaleUp = AnimationUtils.loadAnimation(applicationContext, R.anim.scaleup)

        // Create an AnimationSet to combine both animations
        val animationSet = AnimationSet(true)


        animationSet.addAnimation(fadeIn)

        animationSet.addAnimation(scaleUp)

        val imagenSplash = findViewById<ImageView>(R.id.imagenSplash)

        fadeIn.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation?) {

                // aqui empieza la animacion
            }

            override fun onAnimationEnd(animation: Animation?) {

                // Animation ended; proceed to MainActivity
                val intent = Intent(this@Splash, Home::class.java)
                startActivity(intent)
                finish() // Optional: Close the splash screen activity

            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Animation repeated
            }
        })
        imagenSplash.startAnimation(fadeIn)
        val seconds = valor?.toLong()
        val delayMillis = seconds!!.toLong() // 2 seconds (adjust as needed)

        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed({

           // val intent = Intent(this, MainActivity::class.java)
           // startActivity(intent)
            finish() // Optional: Close the splash screen activity

        }, delayMillis)



    }
}