package com.example.labmusica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.media.PlaybackParams
import android.os.Handler
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class Audio : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mediaPlayerWin: MediaPlayer
    private lateinit var mediaPlayerDefeat: MediaPlayer

    // private lateinit var seekBar: SeekBar
    private lateinit var tvCurrentTime: TextView
    private var playbackParams: PlaybackParams? = null
    private var isSeeking = false
    private val handler = Handler()

    private lateinit var gestureDetector: GestureDetector
    private lateinit var textViewTouchEvent: TextView
    private lateinit var listViewTouchEventHistory: ListView
    private lateinit var touchEventHistory: ArrayList<String>
    private lateinit var historyAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        mediaPlayer = MediaPlayer.create(this, R.raw.fondo)
        mediaPlayerWin = MediaPlayer.create(this, R.raw.win)
        mediaPlayerDefeat = MediaPlayer.create(this, R.raw.defeat)
        playbackParams = mediaPlayer.playbackParams


        gestureDetector = GestureDetector(this,GestureListener())

        // Initialize UI elements()
   //     seekBar = findViewById(R.id.seekBar)
   //     tvCurrentTime = findViewById(R.id.tvCurrentTime)

/*
        // Set up the SeekBar
        seekBar.max = mediaPlayer.duration
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                isSeeking = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                isSeeking = false
            }
        })
*/
        val playButton = findViewById<Button>(R.id.playButton)
        playButton.setOnClickListener {

            if (!mediaPlayerWin.isPlaying) {
                mediaPlayerWin.start()
               // updateSeekBar()
            }
        }



        val stopButton = findViewById<Button>(R.id.stopButton)

        stopButton.setOnClickListener {

            if (mediaPlayerWin.isPlaying) {
                mediaPlayerWin.pause()
               // mediaPlayer.seekTo(0)
               // updateSeekBar()
            }
        }


        val playButtonDefeat = findViewById<Button>(R.id.playButton2)

        playButtonDefeat.setOnClickListener {

            if (!mediaPlayerDefeat.isPlaying) {
                mediaPlayerDefeat.start()
                // updateSeekBar()
            }
        }

        val stopButtonDefeat = findViewById<Button>(R.id.stopButton2)

        stopButtonDefeat.setOnClickListener {

            if (mediaPlayerDefeat.isPlaying) {
                mediaPlayerDefeat.stop()
                //mediaPlayerWin.seekTo(0)
                // updateSeekBar()
            }
        }


        val playButton3 = findViewById<Button>(R.id.IniciarFondo)
        playButton3.setOnClickListener {

            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                // updateSeekBar()
            }
        }



        val stopButton3 = findViewById<Button>(R.id.stopButton3)

        stopButton3.setOnClickListener {

            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                // mediaPlayer.seekTo(0)
                // updateSeekBar()
            }
        }

      /*  val pauseButton = findViewById<Button>(R.id.pauseButton)
        pauseButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
              //  updateSeekBar()
            }
        }
*/

     /*
        val loopButton = findViewById<Button>(R.id.loopButton)
        loopButton.setOnClickListener {
            mediaPlayer.isLooping = !mediaPlayer.isLooping
        }

        val speedUpButton = findViewById<Button>(R.id.speedUpButton)
        speedUpButton.setOnClickListener {
            //mediaPlayer.playbackParams.speed += 0.5f
            changePlaybackSpeed(0.5f)

        }

        val speedDownButton = findViewById<Button>(R.id.speedDownButton)
        speedDownButton.setOnClickListener {
            //mediaPlayer.playbackParams.speed -= 0.5f
            changePlaybackSpeed(-0.5f)
        }
      */


        var boton = findViewById<Button>(R.id.back)

        boton.setOnClickListener {

            val botonNext = Intent(this,Home::class.java)
            startActivity(botonNext)
        }




    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
          //  updateSeekBar()
        }
    }


   /*
    override fun onResume() {
        super.onResume()
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
         //   updateSeekBar()
        }
    }

    */
/*
    private fun updateSeekBar() {
        if (!isSeeking) {
            seekBar.progress = mediaPlayer.currentPosition
            val minutes = mediaPlayer.currentPosition / 1000 / 60
            val seconds = mediaPlayer.currentPosition / 1000 % 60
            val formattedTime = String.format(Locale.getDefault(), "%d:%02d", minutes, seconds)
            tvCurrentTime.text = formattedTime
        }
        if (mediaPlayer.isPlaying) {
            handler.postDelayed({ updateSeekBar() }, 1000)
        }
    }
*/
    /*
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
*/
    inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDoubleTapEvent(e: MotionEvent): Boolean {
            showToast("Toast")
            Log.i("Touch","touch")
            return super.onDoubleTapEvent(e)
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            showToast("onFling")
            return true
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}