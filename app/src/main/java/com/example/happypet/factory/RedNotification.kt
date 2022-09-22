package com.example.happypet.factory

import com.example.happypet.factory.INotification


class RedNotification(
    override var id: String, override var name: String, var level: Int
) : INotification {
}
