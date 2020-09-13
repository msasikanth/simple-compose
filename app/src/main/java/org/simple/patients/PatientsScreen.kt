package org.simple.patients

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.InnerPadding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import org.simple.R
import org.simple.ui.SimpleTheme
import org.simple.ui.grey1

@OptIn(ExperimentalLazyDsl::class)
@Composable
fun PatientsScreen() {
  LazyColumn(
    contentPadding = InnerPadding(bottom = 56.dp),
    content = {
      item { PatientSearchBar() }
      item { SimpleIllustration() }
      item { Spacer(modifier = Modifier.height(4.dp)) }
      item { RecentHeader() }
      items(patientsList) {
        PatientCard(patient = it)
      }
      item { Spacer(modifier = Modifier.height(12.dp)) }
    })
}

@Composable
fun PatientSearchBar() {
  Stack(modifier = Modifier.padding(16.dp)) {
    OutlinedButton(
      modifier = Modifier
        .preferredHeight(56.dp)
        .fillMaxWidth(),
      onClick = { /* Do something */ },
      contentPadding = InnerPadding(start = 16.dp, end = 0.dp)
    ) {
      Icon(Icons.Filled.Search)
      Spacer(modifier = Modifier.width(8.dp))
      Text(text = "Enter patient's name")
      Spacer(modifier = Modifier.weight(1f))
      IconButton(onClick = {/* Do something */ }) {
        Icon(asset = vectorResource(id = R.drawable.ic_code_scanner))
      }
    }
  }
}

@Composable
fun SimpleIllustration() {
  Image(
    modifier = Modifier.fillMaxWidth(),
    asset = vectorResource(id = R.drawable.ic_homescreen),
    contentScale = ContentScale.FillWidth
  )
}

@Composable
fun RecentHeader() {
  Row(
    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
    verticalGravity = Alignment.CenterVertically
  ) {
    Text(
      text = "RECENT",
      style = MaterialTheme.typography.body2.copy(
        fontWeight = FontWeight.Medium,
        color = grey1
      ),
      modifier = Modifier.padding(start = 8.dp)
    )
    Spacer(modifier = Modifier.weight(1f))
    Row(
      modifier = Modifier
        .clickable(onClick = { /* Do something */ })
        .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp)
    ) {
      Image(asset = vectorResource(id = R.drawable.ic_cloud_done))
      Text(
        text = "Synced 5 min ago",
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        style = MaterialTheme.typography.caption
      )
    }
  }
}

@Composable
fun PatientCard(patient: Patient) {
  val patientIcon = when (patient.gender) {
    Gender.Male -> R.drawable.ic_patient_male
    Gender.Female -> R.drawable.ic_patient_female
    Gender.Transgender -> R.drawable.ic_patient_transgender
  }

  val patientVisitedDateString = AnnotatedString.Builder(
    text = "Visited: ${patient.visitedDate}"
  ).apply {
    addStyle(
      MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold).toSpanStyle(),
      start = 0,
      end = 7
    )
  }

  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
      .clickable(onClick = { /* Do something */ }),
  ) {
    Row(modifier = Modifier.padding(16.dp)) {
      Image(asset = vectorResource(id = patientIcon))
      Spacer(modifier = Modifier.width(12.dp))
      Column {
        Text(
          text = "${patient.fullName}, ${patient.gender.displayLetter}, ${patient.age}",
          style = MaterialTheme.typography.body1.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
          ),
          color = MaterialTheme.colors.secondary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = patientVisitedDateString.toAnnotatedString(),
          style = MaterialTheme.typography.body2
        )
      }
    }
  }
}

@Preview(
  device = Devices.PIXEL,
  showBackground = true
)
@Composable
fun PatientsScreenPreview() {
  SimpleTheme {
    PatientsScreen()
  }
}
