package com.example.erims_app.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.erims_app.R
import com.example.erims_app.ui.AppViewModelProvider
import com.example.erims_app.ui.components.CustomNavigationBar
import com.example.erims_app.ui.navigation.AppNavHost
import com.example.erims_app.ui.navigation.Screen

@Composable
fun MainScreen() {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route
    val mainViewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)
    val mainUiState = mainViewModel.mainUiState

    Scaffold(
        bottomBar = {
            CustomNavigationBar(
                navigationItemList = Screen.getNavigationItems(),
                destination = currentDestination,
                onNavigationItemSelected = { selectedItem ->
                    navController.navigate(selectedItem) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                },
                onAddClick = {
                    when (currentRoute) {
                        Screen.Employee.route -> {
                            navController.navigate(Screen.Employee.EmployeeEntry.route)
                            mainViewModel.hideNavigationBar()
                        }
                    }
                },
                modifier = Modifier.padding(dimensionResource(R.dimen.extra_medium_padding)),
                mainUiState = mainUiState
            )
        }
    ) {
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(it)
        )
    }

}