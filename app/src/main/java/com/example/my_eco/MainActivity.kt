package com.example.my_eco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.my_eco.ui.navigation.AppNavGraph
import com.example.my_eco.ui.theme.MyEcoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyEcoTheme {
                AppNavGraph(navController = navController)
            }
        }
    }
}

