package com.huangliner.todocompose.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.to_docompose.data.models.Priority
import com.huangliner.todocompose.components.PriorityDropDown
import com.huangliner.todocompose.ui.theme.LARGE_PADDING
import com.huangliner.todocompose.ui.theme.MEDIUM_PADDING

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = onTitleChange
        )

        Spacer(modifier = Modifier.height(MEDIUM_PADDING))

        PriorityDropDown(
            priority = priority,
            onPriorityChange = onPrioritySelected)

        Spacer(modifier = Modifier.height(MEDIUM_PADDING))

        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = onDescriptionChange
        )
    }
}

