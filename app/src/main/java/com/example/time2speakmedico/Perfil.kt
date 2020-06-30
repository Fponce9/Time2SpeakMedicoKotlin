package com.example.time2speakmedico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.time2speakmedico.Network.Doctor
import com.example.time2speakmedico.Network.KututisApi
import kotlinx.android.synthetic.main.activity_perfil.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        tvNombre.text = doctor.nombre
        tvApellido.setText(doctor.apellido)
        tvCorreo.setText(doctor.correo)
        ivSave.setOnClickListener {
            actualizar()
        }
    }

    private fun actualizar() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("http://time2speak-env.eba-mitec5md.us-east-1.elasticbeanstalk.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val KututisApi = retrofitBuilder.create(KututisApi::class.java)
        val request = KututisApi.editDoctor(doctor)

        if(etContra.text.toString() == etContraRep.text.toString()){

            if (switch1.isChecked){
                deshabilitar()
            }
            request.enqueue(object : Callback<Doctor> {
                override fun onFailure(call: Call<Doctor>, t: Throwable) {
                    Toast.makeText(applicationContext,"No se pudo actualizar la cuenta", Toast.LENGTH_LONG).show()
                    Log.d("MainActivity",t.toString())
                }

                override fun onResponse(call: Call<Doctor>, response: Response<Doctor>) {

                    //Toast.makeText(applicationContext,"Cuenta actualizada", Toast.LENGTH_SHORT).show()
                }
            })
            }
            else{
                Toast.makeText(applicationContext,"Las contraseñas no coinciden", Toast.LENGTH_LONG).show()
            }
    }

    private fun deshabilitar(){
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("http://time2speak-env.eba-mitec5md.us-east-1.elasticbeanstalk.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val KututisApi = retrofitBuilder.create(KututisApi::class.java)
        val request = KututisApi.deshabilitar(doctor.idDoctor)

            request.enqueue(object : Callback<Doctor> {
                override fun onFailure(call: Call<Doctor>, t: Throwable) {
                    Toast.makeText(applicationContext,"No se pudo deshabilitar la cuenta", Toast.LENGTH_LONG).show()
                    Log.d("Perfil: ",t.toString())
                }

                override fun onResponse(call: Call<Doctor>, response: Response<Doctor>) {
                    Toast.makeText(applicationContext,"Cuenta deshabilitada", Toast.LENGTH_LONG).show()
                }
            })

    }
}