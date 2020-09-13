package org.simple.home

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.simple.R
import org.simple.patients.PatientsScreen

private val AppBarHeight = 56.dp

@Composable
fun HomeScreen() {
  var selectedItem by remember { mutableStateOf(0) }

  Scaffold(
    topBar = SimpleTopBar(),
    bottomBar = SimpleBottomBar(
      selectedItem = selectedItem,
      onSelected = { item ->
        selectedItem = item.id
      }
    )
  ) {
    when (selectedItem) {
      NAV_PATIENTS -> PatientsScreen()
      else -> Stack(modifier = Modifier.fillMaxSize()) {
        Text(
          modifier = Modifier.gravity(Alignment.Center),
          text = "To be implemented"
        )
      }
    }
  }
}

@Composable
private fun SimpleTopBar(): @Composable () -> Unit {
  return {
    Surface(elevation = 4.dp) {
      Row(
        modifier = Modifier
          .preferredHeight(AppBarHeight)
          .padding(start = 16.dp)
          .fillMaxWidth(),
        verticalGravity = Alignment.CenterVertically
      ) {
        SimpleFacilityPickerButton()
        Spacer(Modifier.weight(1f))
        IconButton(onClick = { /* Do something */ }) {
          Icon(
            Icons.Filled.Settings,
            tint = MaterialTheme.colors.primary
          )
        }
      }
    }
  }
}

@Composable
private fun SimpleFacilityPickerButton() {
  OutlinedButton(
    shape = RoundedCornerShape(percent = 50),
    onClick = { /* Do something */ }) {
    Image(asset = vectorResource(id = R.drawable.ic_simple_logo))
    Text(
      modifier = Modifier.padding(start = 8.dp, end = 8.dp),
      text = "PHC Obvious"
    )
    Icon(Icons.Filled.ArrowDropDown)
  }
}

@Composable
fun SimpleBottomBar(
  selectedItem: Int,
  onSelected: (NavigationItem) -> Unit
): @Composable () -> Unit {
  return {
    BottomNavigation {
      navigationItemsList.forEach { item ->
        BottomNavigationItem(
          label = { Text(text = item.label) },
          icon = { Icon(asset = vectorResource(id = item.icon)) },
          selected = selectedItem == item.id,
          onSelect = { onSelected(item) }
        )
      }
    }
  }
}
