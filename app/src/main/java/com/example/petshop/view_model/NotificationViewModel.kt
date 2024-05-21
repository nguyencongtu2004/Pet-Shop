package com.example.petshop.view_model

import androidx.lifecycle.ViewModel
import com.example.petshop.model.Notification
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NotificationViewModel : ViewModel() {

    private val _allNotifications = MutableStateFlow<List<Notification>>(listOf(
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
            isSeen = true,
        ),
        Notification(
            title = "Thông báo 5",
            description = "Nội dung thông báo 5",
            isSeen = true,
        ),
    ))
    val allNotifications: StateFlow<List<Notification>> = _allNotifications.asStateFlow()

    fun markAsSeen(notification: Notification) {
        val index = _allNotifications.value.indexOf(notification)
        val newNotification = notification.copy(isSeen = true)
        val newNotifications = _allNotifications.value.toMutableList()
        newNotifications[index] = newNotification
        _allNotifications.update { newNotifications }
    }
}