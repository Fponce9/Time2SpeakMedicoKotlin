package com.example.time2speakmedico.Network

import com.google.gson.annotations.SerializedName

class Doctor (
    @SerializedName("id_doctor")
    val idDoctor : Int,
    val apellido: String,
    var nombre: String,
    var correo: String,
    var telefono: Int
)