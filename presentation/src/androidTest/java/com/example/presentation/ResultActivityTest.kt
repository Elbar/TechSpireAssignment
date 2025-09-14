package com.example.presentation

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.domain.model.Point
import com.example.presentation.di.testAppModule
import com.example.presentation.ui.result.ResultActivity
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTestRule

class ResultActivityTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(testAppModule)
    }

    @Test
    fun recyclerAndChartAreVisible() {
        val intent = Intent(
            ApplicationProvider.getApplicationContext(),
            ResultActivity::class.java
        ).apply {
            putParcelableArrayListExtra(
                "points",
                arrayListOf(Point(1.0, 2.0), Point(3.0, 4.0))
            )
        }
        ActivityScenario.launch<ResultActivity>(intent)

        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
        onView(withId(R.id.chart)).check(matches(isDisplayed()))
    }
}
