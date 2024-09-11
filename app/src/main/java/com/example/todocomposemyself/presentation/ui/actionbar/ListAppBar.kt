package com.example.todocomposemyself.presentation.ui.actionbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.todocomposemyself.R


@ExperimentalMaterial3Api
@Composable
fun ListAppBar(
    searchAction: () -> Unit,
    filterAction: () -> Unit,
    deleteAction: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "列表") },
        actions = {
            ListAppBarAction(
                searchAction = searchAction,
                filterAction = filterAction,
                deleteAction = deleteAction
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            titleContentColor = Color.Black,
            containerColor = Color.LightGray
        )
    )
}

@Composable
fun ListAppBarAction(
    searchAction: () -> Unit,
    filterAction: () -> Unit,
    deleteAction: () -> Unit
) {
    SearchIcon(searchAction = searchAction)
    FilterIcon(filterAction = filterAction)
    DeleteAll(deleteAction = deleteAction)
}

@Composable
fun DeleteAll(deleteAction: () -> Unit) {

    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expanded = true }) {

        Icon(
            painter = painterResource(id = R.drawable.more_vert),
            contentDescription = "全部刪除"
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(text = "全部刪除") },
                onClick = {
                    expanded = false
                    deleteAction
                }
            )
        }
    }
}

@Composable
fun FilterIcon(filterAction: () -> Unit) {
    IconButton(onClick = filterAction) {
        Icon(painter = painterResource(R.drawable.filter), contentDescription = "篩選")
    }
}

@Composable
fun SearchIcon(
    searchAction: () -> Unit
) {
    IconButton(onClick = searchAction) {
        Icon(imageVector = Icons.Filled.Search, contentDescription = "搜尋")
    }
}
