package com.example.erims_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.erims_app.ui.screens.employee.EmployeeDetailsScreen
import com.example.erims_app.ui.screens.home.HomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(modifier = modifier)
        }
        composable(route = Screen.Employee.route) {
            EmployeeDetailsScreen()
        }
    }
}