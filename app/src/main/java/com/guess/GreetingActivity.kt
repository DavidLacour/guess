package com.guess

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.guess.ui.theme.GuessTheme

class GreetingActivity : ComponentActivity() {
    companion object {
         val  KEY : String = "GreetingActivityMessageKey"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GuessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }


    @OptIn(ExperimentalTextApi::class)
    @Composable
    fun Greeting() {
        val rainbowColors = listOf(Color.Blue, Color.Red )
        val brush = remember {
            Brush.linearGradient(
                colors = rainbowColors
            )
        }
        val str =intent.getStringExtra(KEY)
        var text = "Hello " + str + "!"
        TextField(value = text, onValueChange = {text = text }, textStyle = TextStyle(brush = brush, fontWeight = FontWeight.Bold, fontSize = 30.sp) , )

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        GuessTheme {
            Greeting()
        }
    }
}