package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.model.Notification

class NotificationViewModel : ViewModel() {
    var allNotifications: List<Notification> = listOf(
        Notification(
            title = "Thông báo 1",
            description = "Nội dung thông báo 1",
        ),
        Notification(
            title = "Thông báo 2",
            description = "Nội dung thông báo 2",
        ),
        Notification(
            title = "Thông báo 3",
            description = "Nội dung thông báo 3",
        ),
        Notification(
            title = "Thông báo 4",
            description = "Nội dung thông báo 4",
        ),
    )
        private set
}