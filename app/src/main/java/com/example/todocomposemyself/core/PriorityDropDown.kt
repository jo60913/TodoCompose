package com.example.todocomposemyself.core

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todocomposemyself.data.Priority

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    var expend by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .clickable { expend = !expend },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .size(16.dp)
                .weight(1f)
        ) {
            drawCircle(color = priority.color)
        }

        Text(
            modifier = Modifier.weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.bodyMedium
        )

        IconButton(
            modifier = Modifier.weight(1.5f),
            onClick = { expend = true }
        ) {
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "優先權")
        }
    }

    DropdownMenu(
        expanded = expend,
        onDismissRequest = { expend = false }
    ) {
        for(priorityItem in Priority.values()){
            DropdownMenuItem(
                text = { PriorityItem(priority = priorityItem) },
                onClick = {
                    expend = false
                    onPrioritySelected(priorityItem)
                }
            )
        }
    }
}

@Preview
@Composable
fun PreViewPriorityDropDown() {
    PriorityDropDown(
        priority = Priority.LOW,
        onPrioritySelected = {}
    )
}