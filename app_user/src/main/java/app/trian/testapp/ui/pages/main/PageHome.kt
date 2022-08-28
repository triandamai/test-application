package app.trian.testapp.ui.pages.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.main.MonitoringUIState
import app.trian.tes.component.screen.main.ScreenHome
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeHome(
    router: NavHostController
){
    composable(Routes.Main.Home){
        ScreenHome(
            router = router,
            menus = listOf(),
            monitoring = MonitoringUIState(
                loading = false,
                error = false
            ),
            userName = "Trian",
            onDetailTest = {
                router.navigate(Routes.DetailTest.navigate(it)){
                    launchSingleTop = true
                }
            }
        )
    }
}