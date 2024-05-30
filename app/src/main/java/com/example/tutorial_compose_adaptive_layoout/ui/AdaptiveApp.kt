package com.example.tutorial_compose_adaptive_layoout.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.tutorial_compose_adaptive_layoout.data.Quote
import com.example.tutorial_compose_adaptive_layoout.data.local.LocalQuotesProvider
import com.example.tutorial_compose_adaptive_layoout.navigation.navigationItemList
import com.example.tutorial_compose_adaptive_layoout.ui.components.DetailScreen
import com.example.tutorial_compose_adaptive_layoout.ui.components.ListScreen

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AdaptiveApp() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val adaptiveInfo = currentWindowAdaptiveInfo()
    val customNavSuiteType = with(adaptiveInfo) {
        if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED) {
            NavigationSuiteType.NavigationDrawer
        } else {
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        }
    }

    NavigationSuiteScaffold(
        layoutType = customNavSuiteType,
        navigationSuiteItems = {
            navigationItemList.forEach { item ->
                item(
                    icon = { Icon(imageVector = item.icon, contentDescription = item.text) },
                    label = { Text(text = item.text)},
                    selected = currentDestination?.hierarchy?.any { it.route ==  item.text} == true,
                    onClick = {
                        navController.navigate(item.text) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }

                            launchSingleTop = true

                            restoreState = true
                        }
                    }
                )
            }
        }) {
        Scaffold { paddingValues ->
            NavHost(
                navController = navController, startDestination = navigationItemList[0].text) {
                composable(route = navigationItemList[0].text) {
                    val navigator = rememberListDetailPaneScaffoldNavigator<Quote>()

                    BackHandler(navigator.canNavigateBack()) {
                        navigator.navigateBack()
                    }

                    ListDetailPaneScaffold(directive = navigator.scaffoldDirective, value = navigator.scaffoldValue,
                        listPane = {
                            ListScreen(
                                paddingValues = paddingValues,
                                items = LocalQuotesProvider.allQuotes) { quote ->
                                navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, quote)
                            }
                        },
                        detailPane = {
                            val quote = navigator.currentDestination?.content as Quote?
                            AnimatedPane {
                                DetailScreen(quote = quote) {
                                    navigator.navigateBack()
                                }
                            }
                        })
                }

                composable(route = navigationItemList[1].text) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = navigationItemList[1].text)
                    }
                }

                composable(route = navigationItemList[2].text) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = navigationItemList[2].text)
                    }
                }
            }
        }
    }

}