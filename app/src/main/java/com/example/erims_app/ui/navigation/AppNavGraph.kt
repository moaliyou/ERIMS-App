package com.example.erims_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.erims_app.ui.AppViewModelProvider
import com.example.erims_app.ui.screens.employee.EmployeeDetailsScreen
import com.example.erims_app.ui.screens.employee.EmployeeEntryScreen
import com.example.erims_app.ui.screens.home.HomeScreen
import com.example.erims_app.ui.screens.main.MainViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val mainViewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(modifier = modifier)
        }
        composable(route = Screen.Employee.route) {
            EmployeeDetailsScreen()
        }
        composable(route = Screen.Employee.EmployeeEntry.route) {
            EmployeeEntryScreen(
                canNavigateBack = true,
                onNavigationUp = {
                    navController.navigateUp()
                    mainViewModel.showNavigationBar()
                },
                navigateBack = {
                    navController.popBackStack()
                    mainViewModel.showNavigationBar()
                }
            )
        }
    }
}