package app.trian.testapp.ui.pages.splash

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.ScreenSplashScreen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeSplash(
    router: NavHostController
) {
    composable(Routes.Splash) {
        val viewModel = hiltViewModel<SplashViewModel>()

        LaunchedEffect(key1 = Unit, block = {
            viewModel.isUserAlreadyLoggedIn {
                if(it){
                    router.navigate(Routes.Main.MAIN){
                        popUpTo(Routes.Splash){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }else{
                    router.navigate(Routes.Onboard){
                        popUpTo(Routes.Splash){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }
        })
        ScreenSplashScreen()
    }
}
