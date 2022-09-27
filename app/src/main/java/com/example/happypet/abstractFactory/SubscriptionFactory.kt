package com.example.happypet.abstractFactory

abstract class SubscriptionFactory() {
    abstract fun makeSubscription(): ISubscription

    companion object {
        inline fun <reified T : ISubscription> createFactory(): SubscriptionFactory =
            when (T::class) {
                Bronze::class -> GoldFactory()
                Gold::class -> BronzeFactory()
                else -> throw IllegalArgumentException()
            }
    }
}