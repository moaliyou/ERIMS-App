package com.example.erims_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.erims_app.R
import com.example.erims_app.ui.navigation.Screen
import com.example.erims_app.ui.theme.ERIMSAppTheme

@Composable
fun CustomNavigationBar(
    modifier: Modifier = Modifier,
    navigationItemList: List<Screen>,
    destination: NavDestination?,
    onNavigationItemSelected: (String) -> Unit,
    onAddClick: () -> Unit
) {
    Row(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.navigationBars)
            .clip(RoundedCornerShape(dimensionResource(R.dimen.extra_medium_padding)))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(dimensionResource(R.dimen.medium_padding))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        navigationItemList.forEachIndexed { index, screen ->
            val selectedDestination = destination?.hierarchy?.any { currentDestination ->
                currentDestination.route == screen.route
            } == true

            if (index == 2) {
                IconButton(
                    onClick = onAddClick,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.tertiary)
                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add button",
                        tint = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }

            CustomNavigationBarItem(
                navigationItem = screen,
                isSelected = selectedDestination,
                onItemClickChange = { onNavigationItemSelected(screen.route) }
            )
        }
    }
}

@Composable
private fun CustomNavigationBarItem(
    navigationItem: Screen,
    isSelected: Boolean = false,
    onItemClickChange: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(dimensionResource(R.dimen.medium_padding)))
            .clickable(onClick = onItemClickChange)
            .padding(dimensionResource(R.dimen.small_padding))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small_padding)),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(
                    if (isSelected) navigationItem.selectedIcon
                    else navigationItem.unselectedIcon
                ),
                contentDescription = navigationItem.route,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomNavigationBarPreview() {
    ERIMSAppTheme {
        val navigationItemList = Screen.getNavigationItems()
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        CustomNavigationBar(
            navigationItemList = navigationItemList,
            destination = currentDestination,
            onNavigationItemSelected = { navController.navigate(it) },
            onAddClick = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}