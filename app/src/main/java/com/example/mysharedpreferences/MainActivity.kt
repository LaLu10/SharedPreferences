package com.example.mysharedpreferences

import android.content.Context
import android.content.Intent
import android.icu.util.ULocale.getName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val spnOpt = arrayOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValues()
        getSpinner(this, binding.spinner, spnOpt, R.array.colores)
    }
    fun initUI(){
        binding.btnEntrar.setOnClickListener {
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
    fun getSpinner(context: Context, spinner: Spinner, select:Array<String>, idValores:Int) {
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            context, idValores,
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                select[0] = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                select[0] = "Sin selección"
            }
        }
    }
}

