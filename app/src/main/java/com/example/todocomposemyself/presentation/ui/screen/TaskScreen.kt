package com.example.todocomposemyself.presentation.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.todocomposemyself.core.Action
import com.example.todocomposemyself.core.LIST_SCREEN
import com.example.todocomposemyself.data.ToDoTask
import com.example.todocomposemyself.presentation.ui.actionbar.TaskAppBar
import com.example.todocomposemyself.viewmodel.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun TaskScreen(
    naviController: NavHostController,
    viewModel: SharedViewModel,
    selectedTask: ToDoTask?
) {

    val title = viewModel.title
    val description = viewModel.description
    val priority = viewModel.priority
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppBar(
                selectTask = selectedTask,
                navigateToListScreen = { action ->
                    if(action == Action.NO_ACTION){
                        naviController.navigate("list/${action.name}") {
                            popUpTo(LIST_SCREEN) { inclusive = true }
                        }
                    }else{
                        if(viewModel.validateFields()){
                            naviController.navigate("list/${action.name}") {
                                popUpTo(LIST_SCREEN) { inclusive = true }
                            }
                        }else{
                            displayToast(context = context)
                        }
                    }
                    naviController.navigate("list/$action")
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

fun displayToast(context: Context) {
    Toast.makeText(context, "欄位不可為空", Toast.LENGTH_LONG).show()
}
