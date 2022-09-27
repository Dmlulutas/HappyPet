package com.example.happypet.factory

class AlertFactory {
    fun makeAlert(type: AlertType): Alert? {
        return when (type) {
            AlertType.Red -> RedAlert()
            AlertType.Green -> GreenAlert()
            AlertType.Yellow -> YellowAlert()
        }
    }
}