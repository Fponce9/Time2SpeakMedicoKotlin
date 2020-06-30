package com.example.time2speakmedico.Network

import retrofit2.Call
import retrofit2.http.*

interface KututisApi {
    @GET("inciarsesionDoctor/{correo}/{contrasena}")
    fun getDoctorData(@Path("correo") correo: String,@Path("contrasena") contrasena:String): Call<Doctor>

    @POST("Feedback")
    fun postFeedback(@Body terapia:TerapiaPost):Call<TerapiaPost>

    @PUT("actualizarDoctor")
    fun editDoctor(@Body doctor:Doctor):Call<Doctor>

    @POST("deshabilitarDoc/{id}")
    fun deshabilitar(@Path("id") id:Int):Call<Doctor>
}