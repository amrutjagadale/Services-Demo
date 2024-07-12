package com.example.servicesdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.servicesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startService.setOnClickListener {
            intent = Intent(this,MediaPalyerService::class.java)
            intent.putExtra("file_path",binding.edtPath.text.toString())
            startService(intent)
        }

        binding.stopService.setOnClickListener {
            stopService(intent)
        }
    }
}