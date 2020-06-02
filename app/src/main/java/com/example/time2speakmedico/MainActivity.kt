package com.example.time2speakmedico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.time2speakmedico.Network.Doctor
import com.example.time2speakmedico.Network.KututisApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInciarSesion.setOnClickListener {
            Login()
        }
    }

    private fun Login() {
        val correo=etCorreoMain.text.toString()
        val contrasena=etContrasenaMain.text.toString()
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("http://time2speak-env.eba-mitec5md.us-east-1.elasticbeanstalk.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val KututisApi = retrofitBuilder.create(KututisApi::class.java)
        val request = KututisApi.getDoctorData("1")

        request.enqueue(object : Callback<Doctor> {
            override fun onFailure(call: Call<Doctor>, t: Throwable) {
                Toast.makeText(applicationContext,"Su correo o contraseña no son correctos.", Toast.LENGTH_LONG).show()
                Log.d("MainActivity",t.toString())
            }

            override fun onResponse(call: Call<Doctor>, response: Response<Doctor>) {
                Toast.makeText(applicationContext,"Bienvenido Doctor", Toast.LENGTH_LONG).show()
                StartIntent()
            }
        })
    }

    private fun StartIntent() {
        val feedback = Intent(this, Feedback::class.java)
        //intent.putExtra("idPacienteinit", "${usuario.idPaciente}")
        startActivity(feedback)
    }

}