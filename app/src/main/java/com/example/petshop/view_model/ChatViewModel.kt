package com.example.petshop.view_model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.petshop.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class ChatViewModel : ViewModel() {
    private var _messages = MutableStateFlow<List<Message>>(listOf(
        Message("Chào bạn, bạn cần tư vấn gì ạ", "15:18 PM", false),
        Message("Mình không biết chọn món\nShop giúp mình với 😔😔", "15:19 PM", true),
        Message("💓💓", "15:19 PM", true),
        Message("Bạn nuôi thú cưng gì ạ?", "15:20 PM", false)
    ))
    val messages: StateFlow<List<Message>> = _messages.asStateFlow()

    fun addMessage(message: Message) {
        _messages.update { it + message }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendMessage(content: String) {
        val newMessage = Message(
            message = content,
            time = getCurrentTimeFormatted(),
            isMe = true
        )
        addMessage(newMessage)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCurrentTimeFormatted(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH)
        return current.format(formatter)
    }
}
