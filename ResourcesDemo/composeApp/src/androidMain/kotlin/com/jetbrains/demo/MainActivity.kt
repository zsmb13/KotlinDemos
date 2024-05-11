package com.jetbrains.demo

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import resourcesdemo.composeapp.generated.resources.Res
import resourcesdemo.composeapp.generated.resources.`Screenshot 2024_05_06 at 225007`
import resourcesdemo.composeapp.generated.resources.android
import resourcesdemo.composeapp.generated.resources.android3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
            Res.string.android
            Res.drawable.`Screenshot 2024_05_06 at 225007`
            Res.string.android3
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}