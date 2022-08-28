package app.trian.testapp.ui.pages.main

import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.trian.tes.component.Routes

fun NavGraphBuilder.routeProfile(
    router:NavHostController
){
    composable(Routes.Main.Profile){
        Text(text = "sahgs")
    }
}