package com.example.mysharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityAccesBinding

class AccesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAccesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    fun initUI(){
        binding.button.setOnClickListener {
            prefs.wipeData()
            onBackPressed()
        }
        val userName= prefs.getName()
        binding.tvName.text= "Hola $userName"
        if (prefs.getColorCheck()){
            binding.constraintlayout.setBackgroundColor(
                ContextCompat.getColor(this,R.color.purple_200))
        }
    }
}