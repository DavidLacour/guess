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
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    companion object {
         val GREETING_BUTTON : String = "GREETING BUTTON"
         val TEXT_TAG : String = "TEXT_TAG"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            simpleButton()

        }


    }

    @OptIn(ExperimentalTextApi::class)
    @Composable
    fun simpleButton() {
        var text by remember { mutableStateOf(TextFieldValue("enter your name")) }
        var intent = Intent(this, GreetingActivity::class.java)
        Column() {
            Button(onClick = {
                intent.putExtra(GreetingActivity.KEY, text.text.toString())
                startActivity(intent)
            }) {
                Text(text = "GREETING BUTTON")

            }
            val rainbowColors = listOf(Color.Blue,Color.Red )
            val brush = remember {
                Brush.linearGradient(
                    colors = rainbowColors
                )
            }
            TextField(modifier = Modifier.testTag(TEXT_TAG)
                ,value = text, onValueChange = { text = it }, textStyle = TextStyle(brush = brush,fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )

        }
    }
}
