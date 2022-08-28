package app.trian.testapp.ui.pages.onboard

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.ScreenOnboard
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeOnboard(
    router: NavHostController
) {
    composable(Routes.Onboard) {
        ScreenOnboard(
            onGetStarted = {
                router.navigate(Routes.Login){
                    popUpTo(Routes.Splash){
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        )
    }
}
