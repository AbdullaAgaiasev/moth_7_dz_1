package com.example.moth_7_dz_1.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import om.example.moth_7_dz_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}