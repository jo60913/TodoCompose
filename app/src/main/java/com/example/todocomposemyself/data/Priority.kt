package com.example.todocomposemyself.data

import androidx.compose.ui.graphics.Color
import com.example.todocomposemyself.presentation.ui.theme.HighPriorityColor
import com.example.todocomposemyself.presentation.ui.theme.LowPriorityColor
import com.example.todocomposemyself.presentation.ui.theme.MediumPriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(Color.Transparent)
}