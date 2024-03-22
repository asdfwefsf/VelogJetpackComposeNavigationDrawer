package com.company.velogjetpackcomposenavigationdrawer.Screen.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.padding(top = 50.dp)
    ){
        Text(
            text = "HomeScreen",
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            navController.navigate("Bottong1") {
            }
        }) {
            Text("go to bottong1")
        }
        Button(onClick = {
            navController.navigate("Bottong2")
        }) {
            Text("go to bottong2")
        }
    }
}