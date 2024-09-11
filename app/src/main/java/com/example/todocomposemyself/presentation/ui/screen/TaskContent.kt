package com.example.todocomposemyself.presentation.ui.screen

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todocomposemyself.core.PriorityDropDown
import com.example.todocomposemyself.data.Priority

@ExperimentalMaterial3Api
@Composable
fun TaskContent(
    modifier: Modifier = Modifier,
    title: String,
    onValueChange: (String) -> Unit,
    priority: Priority,
    description : String,
    onPrioritySelected: (Priority) -> Unit,
    onDescriptionChange : (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = 12.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onValueChange(it) },
            label = { Text(text = "請輸入") },
            textStyle = MaterialTheme.typography.bodyMedium,
            singleLine = true
        )

        PriorityDropDown(
            priority = priority,
            onPrioritySelected = { onPrioritySelected(it) }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            textStyle = MaterialTheme.typography.bodyMedium
        )
    }
}