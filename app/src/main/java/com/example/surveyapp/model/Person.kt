package com.example.surveyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val nameSurname:String,
    val email:String,
    val city:String,
    val age:Int
):Parcelable
