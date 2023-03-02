package com.guess

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            simpleButton()

        }


    }

    @Composable
    fun simpleButton() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        var intent = Intent(this, GreetingActivity::class.java)
        Column() {
            Button(onClick = {
                intent.putExtra("message_key", text.text.toString())
                startActivity(intent)
            }) {
                Text(text = "simple Button")

            }
            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                }
            )
        }
    }
}
