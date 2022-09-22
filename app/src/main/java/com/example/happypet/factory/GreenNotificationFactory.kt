package com.example.happypet.factory

class GreenNotificationFactory(val id:String, val name:String,val hasCar:Boolean) : NotificationFactory() {
    override fun makeNotif(): INotification = GreenNotification(id,name,hasCar)
}