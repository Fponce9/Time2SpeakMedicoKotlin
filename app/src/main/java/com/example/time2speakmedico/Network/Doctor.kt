package com.example.time2speakmedico.Network

import com.google.gson.annotations.SerializedName

class Doctor (
    @SerializedName("id_doctor")
    var idDoctor : Int,
    var apellido: String,
    var nombre: String,
    var correo: String,
    var telefono: Int,
    var contrasena: String,
    var deshabilitar: Boolean
)