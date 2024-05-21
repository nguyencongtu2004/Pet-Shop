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

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import com.google.firebase.database.FirebaseDatabase

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import com.google.firebase.database.*


class ChatViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages.asStateFlow()

    private val database = FirebaseDatabase.getInstance().reference.child("ChatMessages")

    init {
        // Lắng nghe sự thay đổi trên Firebase khi ứng dụng khởi động
        fetchMessagesFromFirebase()
    }

    private fun fetchMessagesFromFirebase() {
        // Sử dụng addValueEventListener để lắng nghe sự thay đổi trên Firebase
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messageList = mutableListOf<Message>()
                for (messageSnapshot in snapshot.children) {
                    val message = messageSnapshot.getValue(Message::class.java)
                    message?.let {
                        messageList.add(it)
                    }
                }
                // Cập nhật _messages với dữ liệu từ Firebase
                _messages.value = messageList
            }

            override fun onCancelled(error: DatabaseError) {
                // Xử lý lỗi nếu cần
            }
        })
    }

    fun addMessage(message: Message) {
        // Cập nhật _messages với tin nhắn mới
        val updatedMessages = _messages.value.toMutableList()
        updatedMessages.add(message)
        _messages.value = updatedMessages

        // Đồng bộ tin nhắn mới với Firebase
        syncMessageToFirebase(message)
    }

    private fun syncMessageToFirebase(message: Message) {
        // Tạo một key mới cho tin nhắn trên Firebase
        val messageKey = database.push().key ?: return
        // Đặt giá trị cho key với tin nhắn mới trên Firebase
        database.child(messageKey).setValue(message)
            .addOnSuccessListener {
                // Xử lý thành công nếu cần
            }
            .addOnFailureListener {
                // Xử lý lỗi nếu cần
            }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendMessage(content: String) {
        if (content.isEmpty()) return
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

