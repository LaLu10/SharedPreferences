package com.example.mysharedpreferences

import android.content.Intent
import android.icu.util.ULocale.getName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValues()
    }
    fun initUI(){
        binding.btEntrar.setOnClickListener {
            accessSharedPreferences()
        }
    }
    fun checkUserValues(){
        if (prefs.getName().isNotEmpty()){
            goAccess()
        }
    }
    fun accessSharedPreferences(){
        if (binding.etName.text.toString().isNotEmpty()){
            prefs.saveName(binding.etName.text.toString())
            prefs.saveColor(binding.cbColor.isChecked)
            goAccess()
        }else{
            Toast.makeText(this,"Debe rellenar el nombre",Toast.LENGTH_SHORT).show()
        }
    }
    private fun goAccess(){
        startActivity(Intent(this,AccesActivity::class.java))
    }
}

