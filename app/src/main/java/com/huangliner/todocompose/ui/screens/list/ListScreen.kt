package com.huangliner.todocompose.ui.screens.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.util.SearchAppBarState
import com.huangliner.todocompose.R
import com.huangliner.todocompose.ui.theme.fabBackgroundColor
import com.huangliner.todocompose.ui.viewmodel.SharedViewModel

@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    val searchAppBarState :SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState
    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState,
            )
        },
        content = { padding ->
            ListContent()
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