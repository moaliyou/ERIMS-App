package com.example.erims_app.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.erims_app.R
import com.example.erims_app.ui.theme.ERIMSAppTheme

@Composable
fun CustomFAB(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes iconId: Int,
    @StringRes iconTitleId: Int
) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        modifier = modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconId),
            contentDescription = stringResource(iconTitleId),
        )
    }
}

@Preview
@Composable
private fun CustomFABPreview() {
    ERIMSAppTheme {
        CustomFAB(
            onClick = {},
            iconId = R.drawable.ic_check,
            iconTitleId = R.string.employee_entry_title
        )
    }
}