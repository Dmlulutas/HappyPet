package com.example.happypet.factory

class GreenNotification(
    override var id: String,
    override var name: String,
    var hasCar : Boolean,
) : INotification {
}