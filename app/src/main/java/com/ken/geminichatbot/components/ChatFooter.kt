package com.ken.geminichatbot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatFooter(
    onClick: (text: String) -> Unit,
) {
    var inputText by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(10.dp)
    )
    {
        OutlinedTextField(
            value = inputText, onValueChange = { inputText = it },
            placeholder = {
                Text(
                    text = "Type a message",
                    color = Color.Black,
                    style = TextStyle(fontSize = 16.sp)
                )
            },
            modifier = Modifier.weight(1f).padding(end = 10.dp),
//                .background(Color.Gray),
            singleLine = true,
            textStyle = TextStyle(color = Color.Black)
        )

        IconButton(onClick = {
            onClick(inputText)
            inputText = ""
        })
        {
            Icon(
                Icons.Rounded.Send, contentDescription = "Send", tint = Color.White,
                modifier = Modifier.size(40.dp).clip(CircleShape).background(Color.Black)
                    .padding(8.dp)
            )
        }
    }
}