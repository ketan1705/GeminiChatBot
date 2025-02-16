package com.ken.geminichatbot

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatbotVM : ViewModel() {
    val list by lazy {
        mutableStateListOf<ChatModel>()
    }
    private val genAi by lazy {
        GenerativeModel(
            modelName = "gemini-2.0-flash",
            apiKey = BuildConfig.MY_API_KEY
        )
    }

    fun sendMessage(message: String) = viewModelScope.launch {
        val chat = genAi.startChat()

        list.add(
            ChatModel(message, ChatRole.USER.role)
        )
        chat.sendMessage(
            content(ChatRole.USER.role) {
                text(message)
            }).text?.let {
            list.add(ChatModel(it, ChatRole.MODEL.role))
        }
    }
}