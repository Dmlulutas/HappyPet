package com.example.happypet.model


sealed class ResponseModel {
    data class Success(val news: List<Character>): ResponseModel()
    data class Error(val exception: Throwable): ResponseModel()
}