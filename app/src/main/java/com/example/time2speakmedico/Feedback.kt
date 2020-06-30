package com.example.time2speakmedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.time2speakmedico.Network.KututisApi
import com.example.time2speakmedico.Network.TerapiaPost
import kotlinx.android.synthetic.main.activity_feedback.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Feedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        btnFeedback.setOnClickListener {
            enviarFeedback()
        }
        ivEditar2.setOnClickListener {
            startIntent()
        }
    }

    private fun enviarFeedback() {
        val letra = tvLetra.text.toString()
        val comentarios = etFeedback.text.toString()

                            //(USUARIOID,Audio,Comentario,Aprobo,Letra de terapia)
        val feedback = TerapiaPost(2,"0",comentarios,true,letra)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("http://time2speak-env.eba-mitec5md.us-east-1.elasticbeanstalk.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val KututisApi = retrofitBuilder.create(KututisApi::class.java)
        val request = KututisApi.postFeedback(feedback)

        request.enqueue(object : Callback<TerapiaPost> {
            override fun onFailure(call: Call<TerapiaPost>, t: Throwable) {
                Toast.makeText(applicationContext,"Ha ocurrido un error al ingresar el feedback", Toast.LENGTH_LONG).show()
                Log.d("FEEDBACK",t.toString())
            }

            override fun onResponse(call: Call<TerapiaPost>, response: Response<TerapiaPost>) {
                Toast.makeText(applicationContext,"Se ha ingresado el feedback correctamente", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun startIntent() {
        val feedback = Intent(this, Perfil::class.java)
        startActivity(feedback)
    }
}