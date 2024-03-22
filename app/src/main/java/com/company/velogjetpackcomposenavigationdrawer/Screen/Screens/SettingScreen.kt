package com.company.velogjetpackcomposenavigationdrawer.Screen.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen() {
    Box(modifier = Modifier.padding(start = 20.dp, top = 100.dp)) {
        Text(
            text = "SettingScreen",
            fontSize = 50.sp
        )
    }

}