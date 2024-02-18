@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.erims_app.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.erims_app.R
import com.example.erims_app.ui.theme.ERIMSAppTheme

@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    onNavigationBack: () -> Unit,
    canNavigateBack: Boolean = true,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        title = {
            Text(title)
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = onNavigationBack) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior
    )
}

@Preview(showBackground = true)
@Composable
private fun CustomTopAppBarPreview() {
    ERIMSAppTheme {
        CustomTopAppBar(
            title = "Title Example",
            canNavigateBack = true,
            onNavigationBack = {}
        )
    }
}