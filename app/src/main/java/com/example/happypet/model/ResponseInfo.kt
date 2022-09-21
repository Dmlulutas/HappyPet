package com.example.happypet.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseInfo(
    val count: Int,
    val page: Int,
    val next: String,
) : Parcelable
