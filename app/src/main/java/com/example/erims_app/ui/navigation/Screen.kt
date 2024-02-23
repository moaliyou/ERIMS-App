package com.example.erims_app.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.erims_app.R

sealed class Screen(
    val route: String,
    @StringRes val titleResourceId: Int,
    @DrawableRes val selectedIcon: Int = 0,
    @DrawableRes val unselectedIcon: Int = 0,
) {
    data object Home : Screen(
        route = "home",
        titleResourceId = R.string.home_screen_title,
        selectedIcon = R.drawable.ic_dashboard_filled,
        unselectedIcon = R.drawable.ic_dashboard_outline
    )
    data object Employee : Screen(
        route = "employee",
        titleResourceId = R.string.employee_screen_title,
        selectedIcon = R.drawable.ic_employee_filled,
        unselectedIcon = R.drawable.ic_employee_outline
    )

    companion object NavigationItem {
        fun getNavigationItems(): List<Screen> {
            return listOf(
                Home,
                Employee,
            )
        }
    }
}