package com.example.happypet.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Episode(
    val id: String,
    val name: String,
    val episode: String,
    val characters: List<Character>
) : Parcelable