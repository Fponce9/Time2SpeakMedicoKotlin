package com.example.time2speakmedico.Network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface KututisApi {
    @GET("getDoctor/{id}")
    fun getDoctorData(@Path("id") id: String): Call<Doctor>

    @POST("Feedback")
    fun postFeedback(@Body terapia:TerapiaPost):Call<TerapiaPost>
}