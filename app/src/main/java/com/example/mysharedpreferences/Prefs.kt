package com.example.mysharedpreferences

import android.content.Context

class Prefs (val context:Context) {
    val DATABASE= "MyDB"
    val USER_NAME= "UserName"
    val COLOR= "Color"
    val storage= context.getSharedPreferences(DATABASE,Context.MODE_PRIVATE)

    fun saveName(name:String){
        storage.edit().putString(USER_NAME,name).apply()
    }
    fun saveColor(color:Boolean){
        storage.edit().putBoolean(COLOR,color).apply()
    }
    fun getName():String{
        return storage.getString(USER_NAME, "")!!
    }
    fun getColorCheck():Boolean{
        return storage.getBoolean(COLOR,false)
    }
    fun wipeData(){
        storage.edit().clear().apply()
    }
}