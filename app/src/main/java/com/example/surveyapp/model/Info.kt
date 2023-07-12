package com.example.surveyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val person: Person?,
    val aktivite:String,
    val yemek:String,
    val renk:String
):Parcelable
