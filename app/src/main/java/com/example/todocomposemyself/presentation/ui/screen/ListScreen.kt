package com.example.todocomposemyself.presentation.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.todocomposemyself.presentation.ui.actionbar.ListAppBar
import com.example.todocomposemyself.viewmodel.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun ListScreen(
    naviController: NavHostController,
    viewModel: SharedViewModel
) {
    Scaffold(
        topBar = {
            ListAppBar(
                searchAction = {},
                deleteAction = {},
                filterAction = {}
            )
        },
        content = {padding->
            ListContent(
                modifier = Modifier.padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
            )
        },
        floatingActionButton = {
            ListFloatingActionBar(
                floatingAction = {
                    naviController.navigate("task/$it")
                }
            )
        }
    )
}

@Composable
fun ListFloatingActionBar(
    floatingAction: (Int) -> Unit
) {
    FloatingActionButton(
        onClick = { floatingAction(-1) },
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "新增",
            tint = Color.White
        )
    }
}
