package com.ken.geminichatbot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ken.geminichatbot.ChatModel
import com.ken.geminichatbot.ChatRole
import com.ken.geminichatbot.ui.theme.PurpleGrey80

@Composable
fun ChatList(list: MutableList<ChatModel>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list)
        {
            ChatBox(it)
            /* if (it.role == ChatRole.USER.role) {
                 Text(
                     text = it.message, modifier = Modifier.fillMaxWidth()
                         .background(Color.Black).padding(12.dp),
                     color = Color.LightGray,
                     fontSize = 16.sp,
                     fontWeight = FontWeight.SemiBold
                 )
             } else {
                 Text(
                     text = it.message, modifier = Modifier.fillMaxWidth()
                         .background(Color.LightGray).padding(12.dp),
                     color = Color.Black,
                     fontSize = 16.sp,
                     fontWeight = FontWeight.Normal
                 )
             }*/
        }
    }
}

@Composable
fun ChatBox(items: ChatModel) {
    val alignment = if (items.role == ChatRole.USER.role) Alignment.End else Alignment.Start
    val backgroundColor =
        if (items.role == ChatRole.USER.role) MaterialTheme.colorScheme.primary else Color.Gray
    Column(
        modifier = Modifier.fillMaxWidth().padding(5.dp),
    ) {
        Box(
            modifier = Modifier.align(alignment = alignment).clip(
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                    bottomStart = if (items.role == ChatRole.USER.role) 40.dp else 0.dp,
                    bottomEnd = if (items.role == ChatRole.USER.role) 0.dp else 40.dp,
                )
            )
                .background(PurpleGrey80)
                .padding(horizontal = 18.dp, vertical = 16.dp)
        )
        {
            Text(
                text = items.message,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
