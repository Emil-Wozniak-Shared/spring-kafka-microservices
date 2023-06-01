package pl.ejdev.order.service

import pl.ejdev.order.domain.Notification

interface NotificationService {
    fun publish(notification: Notification)
}
