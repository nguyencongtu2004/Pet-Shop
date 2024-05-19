package com.example.petshop.ui.chat

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petshop.model.Message
import com.example.petshop.model.Screen
import com.example.petshop.ui.TopAppBarNoSearch
import com.example.petshop.view_model.ChatViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    chatViewModel: ChatViewModel,
) {
    val messages by chatViewModel.messages.collectAsState()

    Scaffold(
        topBar = {
            TopAppBarNoSearch(
                title = "Chat",
                onBackClick = { navController.popBackStack() },
                isCartEnable = true,
                onCartClick = { navController.navigate(Screen.ShoppingCartScreen.route) },
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            MessageList(messages = messages)
            MessageInput(onMessageSent = { text ->
                chatViewModel.sendMessage(text)
            })
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = if (message.isMe) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (message.isMe) Color(0xFFD3B8AE) else Color(0xFFEFEFEF),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = message.message,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = if (message.isMe) TextAlign.End else TextAlign.Start
                )
                Text(
                    text = message.time,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.align(if (message.isMe) Alignment.End else Alignment.Start)
                )
            }
        }
    }
}

@Composable
fun MessageList(messages: List<Message>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
    ) {
        items(messages) { message ->
            MessageItem(message = message)
        }
    }
}

@Composable
fun MessageInput(onMessageSent: (String) -> Unit) {
    var message by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = message,
            onValueChange = { message = it },
            modifier = Modifier.weight(1f),
            placeholder = { Text("Nhập tin nhắn...") }
        )
        IconButton(
            onClick = {
                if (message.isNotBlank()) {
                    onMessageSent(message)
                    message = ""
                }
            }
        ) {
            Icon(Icons.Filled.Send, contentDescription = "Send")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen(
        chatViewModel = ChatViewModel(),
        navController = rememberNavController(),
    )
}