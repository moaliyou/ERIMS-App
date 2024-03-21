@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.erims_app.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.erims_app.R
import com.example.erims_app.ui.components.CustomTopAppBar
import com.example.erims_app.ui.theme.ERIMSAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = stringResource(R.string.summary_report),
                onNavigationBack = { },
                canNavigateBack = false
            )
        },
        modifier = modifier
    ) { innerPadding ->
        HomeDashboard(
            modifier = Modifier
                .padding(innerPadding)
                .padding(dimensionResource(R.dimen.extra_medium_padding))
        )
    }
}

@Composable
fun HomeDashboard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.extra_medium_padding))
    ) {
        HomeContent(
            dataLabel = stringResource(R.string.employee_card_label),
            data = "590",
            iconId = R.drawable.ic_employee_outline,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            iconBackgroundColor = if (isSystemInDarkTheme()) {
                MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
            } else MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
        )
        HomeContent(
            dataLabel = stringResource(R.string.vesting_period_card_label),
            data = "25",
            iconId = R.drawable.ic_vesting_period,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            iconBackgroundColor = if (isSystemInDarkTheme()) {
                MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
            } else MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
        )
        HomeContent(
            dataLabel = stringResource(R.string.min_contribution_card_label),
            data = "25000",
            iconId = R.drawable.ic_min_wallet,
            containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.6f),
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            iconBackgroundColor = if (isSystemInDarkTheme()) {
                MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f)
            } else MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f)
        )
        HomeContent(
            dataLabel = stringResource(R.string.max_contribution_card_label),
            data = "500",
            iconId = R.drawable.ic_max_wallet,
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            iconBackgroundColor = if (isSystemInDarkTheme()) {
                MaterialTheme.colorScheme.outline
            } else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
        )
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    dataLabel: String,
    data: String,
    iconId: Int,
    containerColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
    iconBackgroundColor: Color = Color.Unspecified
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.extra_medium_padding))
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding))
        ) {
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.icon_container_size))
                    .padding(dimensionResource(R.dimen.medium_padding))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.medium_padding)))
                    .background(color = iconBackgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(iconId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.icon_size))
                        .padding(dimensionResource(R.dimen.small_padding))
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = dataLabel,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = data,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {
    ERIMSAppTheme {
        HomeContent(
            dataLabel = stringResource(R.string.employee_card_label),
            data = "598",
            iconId = R.drawable.ic_check
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeDashboardPreview() {
    ERIMSAppTheme(
        darkTheme = true
    ) {
        HomeDashboard(
            modifier = Modifier.padding(dimensionResource(R.dimen.extra_medium_padding))
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun HomeScreenPreview() {
    ERIMSAppTheme {
        HomeScreen()
    }
}