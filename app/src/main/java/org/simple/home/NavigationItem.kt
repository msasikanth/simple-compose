package org.simple.home

import androidx.annotation.DrawableRes
import org.simple.R

const val NAV_PATIENTS = 0
const val NAV_OVERDUE = 1
const val NAV_PROGRESS = 2

data class NavigationItem(
    val id: Int,
    val label: String,
    @DrawableRes val icon: Int
)

val navigationItemsList = listOf(
    NavigationItem(
        id = NAV_PATIENTS,
        label = "Patients",
        icon = R.drawable.ic_patient
    ),
    NavigationItem(
        id = NAV_OVERDUE,
        label = "Overdue",
        icon = R.drawable.ic_overdue
    ),
    NavigationItem(
        id = NAV_PROGRESS,
        label = "Progress",
        icon = R.drawable.ic_progress
    )
)
