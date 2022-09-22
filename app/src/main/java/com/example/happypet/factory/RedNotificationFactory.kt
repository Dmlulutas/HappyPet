package com.example.happypet.factory

class RedNotificationFactory(val id:String, val name:String, val level:Int) : NotificationFactory() {
    override fun makeNotif(): INotification = RedNotification(id,name,level)
}

