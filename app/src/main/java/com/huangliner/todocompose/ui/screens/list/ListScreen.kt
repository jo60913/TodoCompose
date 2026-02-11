package com.huangliner.todocompose.ui.screens.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.util.Action
import com.example.to_docompose.util.SearchAppBarState
import com.huangliner.todocompose.R
import com.huangliner.todocompose.ui.theme.fabBackgroundColor
import com.huangliner.todocompose.ui.viewmodel.SharedViewModel

@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(true) {
        sharedViewModel.getAllTask()
    }
    val allTasks by sharedViewModel.allTask.collectAsState()
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState
    val scaffoldState = remember { SnackbarHostState() }
    val action by sharedViewModel.action
    DisplaySnackBar(
        state = scaffoldState,
        runAction = {
            sharedViewModel.handleDatabaseActions(action = action) }
    )
    Scaffold(
        snackbarHost = { SnackbarHost(scaffoldState) },
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState,
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                ListContent(
                    tasks = allTasks,
                    navigateToTaskScreen = navigateToTaskScreen
                )
            }
        },
        floatingActionButton = {
            ListFab(onFabClick = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    onFabClick: (Int) -> Unit
) {
    FloatingActionButton(
        onClick = { onFabClick(-1) },
        contentColor = MaterialTheme.colorScheme.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button),
            tint = Color.White
        )
    }
}

@Composable
fun DisplaySnackBar(
    state: SnackbarHostState,
    runAction: () -> Unit
) {
    runAction()
}