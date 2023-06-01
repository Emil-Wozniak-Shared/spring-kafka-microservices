package pl.ejdev.order.service

import org.springframework.stereotype.Service
import pl.ejdev.order.domain.Notification

@Service
class NotificationServiceImpl : NotificationService {
    override fun publish(notification: Notification) {
        TODO("Not yet implemented")
    }
}