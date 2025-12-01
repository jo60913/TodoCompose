package com.example.to_docompose.data.models

import androidx.compose.ui.graphics.Color
import com.huangliner.todocompose.ui.theme.HighPriorityColor
import com.huangliner.todocompose.ui.theme.LowPriorityColor
import com.huangliner.todocompose.ui.theme.MediumPriorityColor
import com.huangliner.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}