package com.ken.geminichatbot

data class ChatModel(val message: String, val role: String)

enum class ChatRole(val role: String) {
    USER("user"),
    MODEL("model")
}
