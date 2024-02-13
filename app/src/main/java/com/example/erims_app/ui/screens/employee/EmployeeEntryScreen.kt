package com.example.erims_app.ui.screens.employee

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.erims_app.R
import com.example.erims_app.ui.theme.ERIMSAppTheme
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun EmployeeEntryScreen() {

}

@Composable
fun EmployeeBody() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EmployeeForm(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium_padding))
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "First name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Last name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Date of birth") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Job title") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Salary") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.fillMaxWidth()
        )
        val datePickerState = rememberDatePickerState()
        TransactionDatePicker(datePickerState = datePickerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionDatePicker(datePickerState: DatePickerState) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp, 8.dp)
    ) {
        val showDialog = remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    showDialog.value = true
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f),
                text = if (datePickerState.selectedDateMillis != null) {
                    SimpleDateFormat(
                        "MMMM d, yyyy",
                        Locale.getDefault()
                    ).format(datePickerState.selectedDateMillis)
                } else {
                    "Choose Date"
                },
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(8.dp)
            )
        }


        if (showDialog.value) {
            val confirmEnabled =
                remember { derivedStateOf { datePickerState.selectedDateMillis != null } }
            DatePickerDialog(
                onDismissRequest = {
                    showDialog.value = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog.value = false

                        },
                        enabled = confirmEnabled.value
                    )
                    {
                        Text("Ok")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDialog.value = false
                        }
                    ) {
                        Text("Dismiss")
                    }
                }
            ) {
                DatePicker(state = datePickerState, showModeToggle = false)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DatePickerPreview() {
    val datePickerState = rememberDatePickerState()
    ERIMSAppTheme {
        TransactionDatePicker(datePickerState = datePickerState)
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeFormPreview() {
    ERIMSAppTheme {
        EmployeeForm(
            modifier = Modifier.padding(dimensionResource(R.dimen.extra_medium_padding))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeEntryScreenPreview() {
    ERIMSAppTheme {
        EmployeeEntryScreen()
    }
}