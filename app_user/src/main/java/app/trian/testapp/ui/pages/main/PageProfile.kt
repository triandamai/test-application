package app.trian.testapp.ui.pages.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.main.ProfileUIState
import app.trian.tes.component.screen.main.ScreenProfile

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeProfile(
    router:NavHostController
){
    composable(Routes.Main.Profile){
        ScreenProfile(
            router = router,
            menus = listOf(),
            profile = ProfileUIState(),
            onFabClick = {},
            onSetting = {},
            onRestartActivity = {}
        )
    }
}