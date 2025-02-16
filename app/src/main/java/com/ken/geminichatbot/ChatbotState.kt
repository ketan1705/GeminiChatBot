package com.ken.geminichatbot

sealed interface ChatbotState {
    data object Ideal : ChatbotState
    data object Loading : ChatbotState
    data class Success(val result: String) : ChatbotState
    data class Error(val error: String) : ChatbotState
}