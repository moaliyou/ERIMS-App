package com.example.erims_app.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.erims_app.R

sealed class Screen(
    val route: String,
    @StringRes val titleResourceId: Int = 0,
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
    ) {
        data object EmployeeEntry : Screen(
            route = "employee_entry",
            titleResourceId = R.string.employee_entry_title
        )
    }

    data object Retirement : Screen(
        route = "retirement",
        titleResourceId = R.string.retirement_screen_title,
        selectedIcon = R.drawable.ic_retirement_filled,
        unselectedIcon = R.drawable.ic_retirement_outline
    ) {
        data object Plan : Screen(
            route = "plan",
            titleResourceId = R.string.retirement_plan_screen_title,
            selectedIcon = R.drawable.ic_plan_filled,
            unselectedIcon = R.drawable.ic_plan_outline
        )

        data object Benefit : Screen(
            route = "benefit",
            titleResourceId = R.string.retirement_benefit_screen_title,
            selectedIcon = R.drawable.ic_benefit_filled,
            unselectedIcon = R.drawable.ic_benefit_outline
        )
    }

    data object Payout : Screen(
        route = "payout",
        titleResourceId = R.string.payout_screen_title,
        selectedIcon = R.drawable.ic_payout_filled,
        unselectedIcon = R.drawable.ic_payout_outline
    )

    companion object NavigationItem {
        fun getNavigationItems(): List<Screen> {
            return listOf(
                Home,
                Employee,
                Retirement,
                Payout
            )
        }
    }
}