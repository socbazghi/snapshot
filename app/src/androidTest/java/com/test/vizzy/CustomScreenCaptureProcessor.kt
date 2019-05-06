package com.test.vizzy

import android.os.Environment.DIRECTORY_PICTURES
import android.os.Environment.getExternalStoragePublicDirectory
import android.support.test.runner.screenshot.BasicScreenCaptureProcessor
import android.support.test.runner.screenshot.Screenshot
import android.util.Log
import java.io.File
import java.io.IOException

class MyScreenCaptureProcessor(parentFolderPath: String) : BasicScreenCaptureProcessor() {

    init {
        this.mDefaultScreenshotPath = File(
                File(
                        getExternalStoragePublicDirectory(DIRECTORY_PICTURES),
                        "my_app_folder"
                ).absolutePath,
                "screenshots/$parentFolderPath"
        )
    }

    override fun getFilename(prefix: String): String = prefix
}

fun takeScreenshot(parentFolderPath: String = "", screenShotName: String) {
    Log.d("Screenshots", "Taking screenshot of '$screenShotName'")
    val screenCapture = Screenshot.capture()
    val processors = setOf(MyScreenCaptureProcessor(parentFolderPath))
    try {
        screenCapture.apply {
            name = screenShotName
            process(processors)
        }
        Log.d("Screenshots", "Screenshot taken")
    } catch (ex: IOException) {
        Log.e("Screenshots", "Could not take the screenshot", ex)
    }
}