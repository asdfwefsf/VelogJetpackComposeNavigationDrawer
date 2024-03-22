package com.company.velogjetpackcomposenavigationdrawer.Screen

sealed class Screen (val route : String) {
    object HomeScreen : Screen("Home")
    object MessageScreen : Screen("Message")
    object SettingScreen : Screen("Setting")
    object BottongScreen1 : Screen("Bottong1")
    object BottongScreen2 : Screen("Bottong2")
}
