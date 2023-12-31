package com.bong.mvvmtodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bong.mvvmtodoapp.ui.add_edit_todo.AddEditTodoScreen
import com.bong.mvvmtodoapp.ui.theme.MvvmtodoappTheme
import com.bong.mvvmtodoapp.ui.todo_list.TodoListScreen
import com.bong.mvvmtodoapp.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmtodoappTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.TODO_LIST) {
                    composable(route = Routes.TODO_LIST) {
                        TodoListScreen(onNavigate = {
                            navController.navigate(
                                it.route
                            )
                        })
                    }
                    composable(route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                        arguments = listOf(
                            navArgument(name = "todoId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) { AddEditTodoScreen(onPopBackStack = { navController.popBackStack() }) }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(text: String) {
    Text(text)
}