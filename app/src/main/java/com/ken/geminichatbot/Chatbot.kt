package com.ken.geminichatbot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ken.geminichatbot.components.ChatFooter
import com.ken.geminichatbot.components.ChatHeader
import com.ken.geminichatbot.components.ChatList

@Composable
fun ChatBot(viewModel: ChatbotVM = viewModel()) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(
            Brush.linearGradient(
                listOf(Color(0xFF2be4dc), Color(0xFF243484))
            )
        )
    )
    {
        ChatHeader()
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ChatList(list = viewModel.list)
        }
        ChatFooter {
            if (it.isNotEmpty()) {
                // send input to gemini
                viewModel.sendMessage(it)
            }
        }
    }
}