package com.example.erims_app.ui.screens.employee

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.erims_app.R
import com.example.erims_app.ui.components.CustomDatePicker
import com.example.erims_app.ui.theme.ERIMSAppTheme

@Composable
fun EmployeeEntryScreen(
    onSaveClick: () -> Unit
) {
//    EmployeeEntryBody(
//        onSaveClick = onSaveClick,
//        modifier = Modifier.fillMaxWidth()
//    )
}

@Composable
fun EmployeeEntryBody(
    modifier: Modifier = Modifier,
    onSaveClick: () -> Unit,
    employeeUiState: EmployeeUiState
) {
    Column(
        modifier = modifier.padding(dimensionResource(R.dimen.extra_medium_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding)),
        horizontalAlignment = Alignment.End
    ) {
        EmployeeForm(
            modifier = Modifier.fillMaxWidth(),
            employeeDetails = employeeUiState.employeeDetails
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.medium,
            enabled = employeeUiState.isEntryValid
        ) {
            Text(text = stringResource(R.string.save_button))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EmployeeForm(
    modifier: Modifier = Modifier,
    employeeDetails: EmployeeDetails,
    onValueChange: (EmployeeDetails) -> Unit = {},
    enabled: Boolean = true
) {
    val datePickerState = rememberDatePickerState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding))
    ) {
        TextField(
            value = employeeDetails.firstName,
            onValueChange = { onValueChange(employeeDetails.copy(firstName = it)) },
            label = { Text(text = stringResource(R.string.first_name)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = employeeDetails.lastName,
            onValueChange = { onValueChange(employeeDetails.copy(lastName = it)) },
            label = { Text(text = stringResource(R.string.last_name)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        CustomDatePicker(
            datePickerState = datePickerState,
            dateFormat = stringResource(R.string.date_format),
            dateLabel = stringResource(R.string.date_of_birth)
        )
        TextField(
            value = employeeDetails.jobTitle,
            onValueChange = { onValueChange(employeeDetails.copy(jobTitle = it)) },
            label = { Text(text = stringResource(R.string.job_title)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = employeeDetails.salary,
            onValueChange = { onValueChange(employeeDetails.copy(salary = it)) },
            label = { Text(text = stringResource(R.string.salary)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeFormPreview() {
    ERIMSAppTheme {
        EmployeeForm(
            modifier = Modifier.padding(dimensionResource(R.dimen.extra_medium_padding)),
            employeeDetails = EmployeeDetails()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeEntryScreenPreview() {
    ERIMSAppTheme {
        EmployeeEntryScreen(
            onSaveClick = {}
        )
    }
}