package com.test.vizzy

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VizzySnapshotTest {

    @get:Rule
    val testRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun takePicOfHomescreen() {
        takeScreenshot( screenShotName = "homescreen")
    }
}