package com.gustavogoma.android.dramatickey

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mp = MediaPlayer.create(this, R.raw.c1)

        dramatic_key.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> { play() }
                MotionEvent.ACTION_UP -> { stop() }
            }

            true
        }
    }

    fun play() {
        mp.start()
    }

    fun stop() {
        mp.stop()
        mp.release()
        mp = MediaPlayer.create(this, R.raw.c1)
    }
}
