package com.example.time2speakmedico.Network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface KututisApi {
    @GET("getDoctor/{id}")
    fun getDoctorData(@Path("id") id: String): Call<Doctor>
}