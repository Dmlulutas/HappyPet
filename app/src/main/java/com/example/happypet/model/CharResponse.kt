package com.example.happypet.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharResponse(
    val info: ResponseInfo,
    val results: List<Character>,
) : Parcelable
