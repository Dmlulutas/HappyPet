package com.example.happypet.model

import android.os.Parcelable
import com.example.happypet.model.enums.Gender
import com.example.happypet.model.enums.Species
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name :String,
    val image : String,
    val gender : Gender,
    val species: Species
) : Parcelable
