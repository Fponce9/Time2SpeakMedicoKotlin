package com.example.time2speakmedico.Network

import com.google.gson.annotations.SerializedName

class TerapiaPost (
    val pacienteIdPaciente : Int,
    val audio: String,
    var comentarios: String,
    var resultado: Boolean,
    var terapiaIdLetra: String
)