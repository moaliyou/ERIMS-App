package com.example.erims_app.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.erims_app.R
import com.example.erims_app.ui.theme.ERIMSAppTheme

@Composable
fun HomeScreen() {
    
}

@Composable
fun HomeDashboard() {

}

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.extra_medium_padding))
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.employee_card_label),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    Icons.Outlined.Person,
                    contentDescription = null
                )
            }
            Text(
                text = "569"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    ERIMSAppTheme {
        HomeContent()
    }
}