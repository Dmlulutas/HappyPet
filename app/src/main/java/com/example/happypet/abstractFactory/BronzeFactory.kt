package com.example.happypet.abstractFactory

class BronzeFactory() : SubscriptionFactory() {
    override fun makeSubscription(): ISubscription = Gold()
}