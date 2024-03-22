package com.company.velogjetpackcomposenavigationdrawer.Screen.Screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.company.velogjetpackcomposenavigationdrawer.MainViewModel

@Composable
fun Bottong1(navController: NavController , viewModel : MainViewModel) {
    Column(
        modifier = Modifier.padding(top = 100.dp)
    ) {
        Text("bottong1")
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            viewModel.changeState("Bottong2")
            navController.navigate(viewModel.state)
            Log.d("ddd" , viewModel.state)

        }) {
            Text("go to Bottong2")
        }
    }
}