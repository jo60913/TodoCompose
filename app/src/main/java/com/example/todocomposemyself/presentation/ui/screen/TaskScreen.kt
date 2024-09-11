package com.example.todocomposemyself.presentation.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.todocomposemyself.data.Priority
import com.example.todocomposemyself.presentation.ui.actionbar.TaskAppBar
import com.example.todocomposemyself.viewmodel.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun TaskScreen(
    naviController: NavHostController,
    viewModel: SharedViewModel
) {

    val title = viewModel.title
    val description = viewModel.description
    val priority = viewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                doneAction = {},
                navigateToListScreen = {
                    naviController.navigate("list/$it")
                }
            )
        },
        content = { padding ->
            TaskContent(
                modifier = Modifier.padding(        //這邊需要傳入頂部的距離 不然顯示的時候會從畫面最頂部開始往下渲染，導致最上面有一段會被topbar擋住
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                ),
                title = title,
                onValueChange = { },
                priority = priority,
                description = description,
                onDescriptionChange = {},
                onPrioritySelected = {}
            )
        },
    )
}