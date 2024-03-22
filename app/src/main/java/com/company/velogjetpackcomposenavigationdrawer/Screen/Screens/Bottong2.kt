package com.company.velogjetpackcomposenavigationdrawer.Screen.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Bottong2(navController: NavController) {
    Column(
        modifier = Modifier.padding(top = 100.dp)
    ) {
        Text("bottong2")
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            navController.navigate("Bottong1")
        }) {
            Text("go to Bottong1")
        }
    }
}