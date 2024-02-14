@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.erims_app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.erims_app.R
import com.example.erims_app.ui.theme.ERIMSAppTheme
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(datePickerState: DatePickerState) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(
                dimensionResource(R.dimen.extra_medium_padding),
                dimensionResource(R.dimen.medium_padding)
            )
    ) {
        val isDialogVisible = remember { mutableStateOf(false) }
        val confirmEnabled by remember {
            derivedStateOf { datePickerState.selectedDateMillis != null }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isDialogVisible.value = true },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = if (datePickerState.selectedDateMillis != null) {
                    SimpleDateFormat(
                        stringResource(R.string.date_format),
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
        ShowDateDialog(
            state = datePickerState,
            isDialogVisible = isDialogVisible.value,
            onDismiss = { isDialogVisible.value = false },
            confirmButtonAction = {
                TextButton(
                    onClick = { isDialogVisible.value = false },
                    enabled = confirmEnabled
                ) {
                    Text(stringResource(R.string.date_picker_dialog_OK))
                }
            },
            dismissButtonAction = {
                TextButton(
                    onClick = { isDialogVisible.value = false }
                ) {
                    Text(stringResource(R.string.date_picker_dialog_DISMISS))
                }
            }
        )
    }
}

@Composable
fun ShowDateDialog(
    state: DatePickerState,
    onDismiss: () -> Unit,
    confirmButtonAction: @Composable () -> Unit,
    dismissButtonAction: @Composable () -> Unit,
    isDialogVisible: Boolean,
) {
    if (isDialogVisible) {
        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = confirmButtonAction,
            dismissButton = dismissButtonAction
        ) {
            DatePicker(state = state, showModeToggle = false)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DatePickerPreview() {
    val datePickerState = rememberDatePickerState()
    ERIMSAppTheme {
        CustomDatePicker(datePickerState = datePickerState)
    }
}