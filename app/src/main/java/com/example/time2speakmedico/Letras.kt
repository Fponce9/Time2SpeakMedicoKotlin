package com.example.time2speakmedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_letras.*

class Letras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letras)
         ivEditar.setOnClickListener{
             StartIntent()
         }
    }

    private fun StartIntent() {
        val perfil = Intent(this, Perfil::class.java)
        startActivity(perfil)
    }
}