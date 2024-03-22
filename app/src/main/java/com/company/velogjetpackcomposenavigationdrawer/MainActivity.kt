package com.company.velogjetpackcomposenavigationdrawer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.company.velogjetpackcomposenavigationdrawer.Navigation.NavigationDrawerItem
import com.company.velogjetpackcomposenavigationdrawer.Navigation.items
import com.company.velogjetpackcomposenavigationdrawer.Screen.Screen
import com.company.velogjetpackcomposenavigationdrawer.Screen.Screens.Bottong1
import com.company.velogjetpackcomposenavigationdrawer.Screen.Screens.Bottong2
import com.company.velogjetpackcomposenavigationdrawer.Screen.Screens.HomeScreen
import com.company.velogjetpackcomposenavigationdrawer.Screen.Screens.MessageScreen
import com.company.velogjetpackcomposenavigationdrawer.Screen.Screens.SettingScreen
import com.company.velogjetpackcomposenavigationdrawer.ui.theme.VelogJetpackComposeNavigationDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VelogJetpackComposeNavigationDrawerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationDrawer()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    val navController = rememberNavController()

    DismissibleNavigationDrawer( // PermanentNavigationDrawer
        drawerContent = {
            ModalDrawerSheet { // PermanentDrawerSheet
                Spacer(modifier = Modifier.height(16.dp))
                items.forEachIndexed { index, navigationDrawerItem ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = navigationDrawerItem.title)
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(navigationDrawerItem.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    navigationDrawerItem.selectedIcon
                                } else navigationDrawerItem.unselectedIcon,
                                contentDescription = navigationDrawerItem.title
                            )
                        },
                        badge = {
                            navigationDrawerItem.badgeCount?.let {
                                Text(text = navigationDrawerItem.badgeCount.toString())
                            }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "NavDrawer Study")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) {
            it
            val viewModel = MainViewModel()
            NavHost(navController = navController, startDestination = "maingroup") {
                navigation(startDestination = Screen.HomeScreen.route , route = "maingroup") {
                    composable(Screen.HomeScreen.route) {
                        var state : String = viewModel.state
                        Log.d("ddd" , viewModel.state)

                        if(state == "Home") {
                            HomeScreen(navController)
                        }
                        if(state == "Bottong2") {
                            Bottong2(navController)
                        }

                    }
                    composable(Screen.BottongScreen1.route) {
                        Bottong1(navController , viewModel)
                    }
                    composable(Screen.BottongScreen2.route) {
                        Bottong2(navController)
                    }
                }

                composable(Screen.MessageScreen.route) {
                    MessageScreen()
                }
                composable(Screen.SettingScreen.route) {
                    SettingScreen()
                }

            }

        }
    }
}