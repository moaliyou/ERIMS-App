package com.example.erims_app.ui.screens.employee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.erims_app.R
import com.example.erims_app.data.local.entities.Employee
import com.example.erims_app.ui.theme.ERIMSAppTheme

@Composable
fun EmployeeDetailsScreen(

) {

}

@Composable
private fun EmployeeDetailsBody(
    modifier: Modifier = Modifier,
    employeeList: List<Employee>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (employeeList.isEmpty()) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_empty),
                contentDescription = stringResource(R.string.empty_list),
                modifier = Modifier
                    .size(64.dp)
                    .padding(bottom = dimensionResource(R.dimen.extra_medium_padding)),
                tint = MaterialTheme.colorScheme.outline
            )
            Text(
                text = stringResource(R.string.no_employee_description),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            EmployeeList(
                employeeList = employeeList,
                modifier = Modifier.padding(dimensionResource(R.dimen.small_padding))
            )
        }
    }
}

@Composable
private fun EmployeeList(
    modifier: Modifier = Modifier,
    employeeList: List<Employee>
) {
    LazyColumn(modifier = modifier) {
        items(items = employeeList, key = { it.id }) { employee ->
            EmployeeContent(
                employee = employee,
                modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding))
            )
        }
    }
}

@Composable
private fun EmployeeContent(
    modifier: Modifier = Modifier,
    employee: Employee
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.medium_padding))
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.extra_medium_padding))
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.extra_medium_padding))
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${employee.firstName} ${employee.lastName}",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = employee.jobTitle,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            EmployeeContentRow(
                employeeId = employee.id,
                employeeDateOfBirth = employee.dateOfBirth,
                employeeSalary = employee.salary,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.medium_padding)))
                    .background(MaterialTheme.colorScheme.outlineVariant)
                    .padding(dimensionResource(R.dimen.extra_medium_padding)),
            )
        }
    }
}

@Composable
private fun EmployeeContentRow(
    employeeId: Int,
    employeeDateOfBirth: String,
    employeeSalary: Double,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = stringResource(R.string.id_label),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "#0$employeeId",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Column {
            Text(
                text = stringResource(R.string.date_of_birth),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = employeeDateOfBirth,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Column {
            Text(
                text = stringResource(R.string.salary),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "$$employeeSalary",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmployeeContentPreview() {
    val employee = Employee(
        id = 291,
        firstName = "Ahmed",
        lastName = "Osman Salah",
        dateOfBirth = "12-02-1992",
        jobTitle = "Software Engineering",
        salary = 500.0
    )
    ERIMSAppTheme {
        EmployeeContent(employee = employee)
    }
}

@Preview(showBackground = true)
@Composable
private fun EmployeeListPreview() {
    val employeeList = listOf(
        Employee(
            id = 291,
            firstName = "Ahmed",
            lastName = "Osman Salah",
            dateOfBirth = "12-02-1992".replace("-", " "),
            jobTitle = "Software Engineering",
            salary = 500.0
        ),
        Employee(
            id = 463,
            firstName = "Hajji",
            lastName = "Hassan Omar",
            dateOfBirth = "28-04-1988".replace("-", " "),
            jobTitle = "Web Designer",
            salary = 750.0
        )
    )
    ERIMSAppTheme {
        EmployeeList(
            employeeList = employeeList
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EmployeeDetailsBodyPreview() {
    val employeeList = listOf(
        Employee(
            id = 291,
            firstName = "Ahmed",
            lastName = "Osman Salah",
            dateOfBirth = "12-02-1992".replace("-", " "),
            jobTitle = "Software Engineering",
            salary = 500.0
        ),
        Employee(
            id = 463,
            firstName = "Hajji",
            lastName = "Hassan Omar",
            dateOfBirth = "28-04-1988".replace("-", " "),
            jobTitle = "Web Designer",
            salary = 750.0
        )
    )
    ERIMSAppTheme {
        EmployeeDetailsBody(
            employeeList = emptyList(),
            modifier = Modifier.fillMaxSize()
        )
    }
}