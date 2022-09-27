package com.example.happypet.abstractFactory

class GoldFactory() : SubscriptionFactory() {
    override fun makeSubscription(): ISubscription = Bronze()
}