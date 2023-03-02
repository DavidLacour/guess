package com.guess

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import org.hamcrest.core.AllOf.allOf
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()




    val str = "Alice Roosevelt"
    @Test
    fun tryingIntend() {
        composeTestRule.setContent { MainActivity() }
        Intents.init()
        composeTestRule
            .onNode(hasClickAction())
            .performClick() // Equivalent to onNodeWithText("Button")   // Build the result to return when the activity is launched.
        intended(
            allOf(
                hasExtra(GreetingActivity.KEY, "enter your name")
            )
        )
        Intents.release()

    }
}