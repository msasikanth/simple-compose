package org.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import org.simple.home.HomeScreen
import org.simple.ui.SimpleTheme

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SimpleTheme {
        HomeScreen()
      }
    }
  }
}

@Preview(
  device = Devices.PIXEL_3
)
@Composable
fun DefaultPreview() {
  SimpleTheme {
    HomeScreen()
  }
}