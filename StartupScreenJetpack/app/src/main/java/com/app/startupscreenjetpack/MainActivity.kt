package com.app.startupscreenjetpack

import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.app.startupscreenjetpack.ui.screen.AutoSlide
import com.app.startupscreenjetpack.ui.theme.StartupScreenJetpackTheme

class MainActivity : BaseActivity() {

    @Composable
    override fun BuildContent() {
        setContent {
            StartupScreenJetpackTheme {
                AutoSlide()
            }
        }

    }
}

