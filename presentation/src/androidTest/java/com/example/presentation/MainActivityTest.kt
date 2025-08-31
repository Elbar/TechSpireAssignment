package com.example.presentation

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.presentation.di.testAppModule
import com.example.presentation.ui.main.MainActivity
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.test.KoinTestRule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(testAppModule)
    }

    @Test
    fun infoTextIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.tvInfo))
            .check(matches(isDisplayed()))
            .check(matches(withText("Введите количество точек и нажмите «Поехали»")))
    }

    @Test
    fun enteringInvalidNumber_showsToast() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.etCount))
            .perform(typeText("0"), closeSoftKeyboard())
        onView(withId(R.id.btnGo)).perform(click())

        onView(withText("Введите корректное число"))
            .inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}
