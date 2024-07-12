package com.example.servicesdemo

import android.app.Service
import android.content.Intent
import android.media.AsyncPlayer
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast

class MediaPalyerService :Service() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var uri : Uri

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        makeToast("onStartCommand started")

        if (intent!=null){
            var path = intent.getStringExtra("file_path")
            uri = Uri.parse(path)
        }
        mediaPlayer = MediaPlayer.create(this,uri)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        return START_STICKY
    }
    override fun onCreate() {
        makeToast("onCreate called ")
        super.onCreate()

    }

    override fun onDestroy() {
        makeToast("onDestroy called")
        super.onDestroy()

    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun makeToast(text : String){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }
}