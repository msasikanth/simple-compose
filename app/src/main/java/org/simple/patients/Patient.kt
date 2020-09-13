package org.simple.patients

val Gender.displayLetter: String
  get() = when (this) {
      Gender.Male -> "M"
      Gender.Female -> "F"
      Gender.Transgender -> "T"
  }

sealed class Gender {
  object Male : Gender()
  object Female : Gender()
  object Transgender : Gender()
}

data class Patient(
    val fullName: String,
    val gender: Gender,
    val age: String,
    val visitedDate: String
)

val patientsList = listOf(
    Patient(
        fullName = "Jane Doe",
        gender = Gender.Female,
        age = "23",
        visitedDate = "13-Sep-2020"
    ),
    Patient(
        fullName = "John Doe",
        gender = Gender.Male,
        age = "28",
        visitedDate = "26-Aug-2020"
    ),
    Patient(
        fullName = "Narayana Kumar",
        gender = Gender.Transgender,
        age = "56",
        visitedDate = "17-Aug-2020"
    ),
    Patient(
        fullName = "Wade Wilson",
        gender = Gender.Male,
        age = "38",
        visitedDate = "12-Aug-2020"
    ),
    Patient(
        fullName = "Reena Malik",
        gender = Gender.Female,
        age = "52",
        visitedDate = "12-Aug-2020"
    ),
    Patient(
        fullName = "Anish Acharya",
        gender = Gender.Male,
        age = "47",
        visitedDate = "11-Aug-2020"
    ),
)
