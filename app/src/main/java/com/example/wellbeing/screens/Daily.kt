package com.example.wellbeing.screens

import androidx.compose.foundation.ExperimentalFoundationApi


import androidx.compose.runtime.Composable

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wellbeing.view.FruitGrid

import com.example.wellbeing.view.FruitsDataDetails



import com.google.gson.Gson
import com.malkinfo.gridlayoutexample.model.FruitsData
import com.malkinfo.gridlayoutexample.view.FruitGrid


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DailyScreen(){
    val navHostController = rememberNavController()



    NavHost(
        navController = navHostController,
        startDestination = "fruits_data"
    ){
        composable("fruits_data"){
            FruitGrid()
        }
        composable("grid_detail/{item}",
            arguments = listOf(
                navArgument("item"){
                    type = NavType.StringType
                }
            )
        ){navBackStackEntry ->

            navBackStackEntry.arguments?.getString("item")?.let { json->
                val item = Gson().fromJson(json, FruitsData::class.java)
                FruitsDataDetails(data = item)

            }
        }
    }


}
