package com.example.happypet.factory

abstract class NotificationFactory() {
    abstract fun makeNotif(): INotification

    companion object {
        inline fun <reified T : INotification> createFactory(
            id: String,
            name: String,
            level:Int,
            hasCar:Boolean
        ): NotificationFactory =
            when (T::class) {
                RedNotification::class -> RedNotificationFactory(id, name,level )
                GreenNotification::class -> GreenNotificationFactory(id, name,hasCar )
                else -> throw IllegalArgumentException()
            }
    }
}