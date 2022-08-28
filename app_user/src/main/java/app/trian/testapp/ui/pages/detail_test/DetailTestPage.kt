package app.trian.testapp.ui.pages.detail_test

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.ScreenDetailTest
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeDetailTest(
    router:NavHostController
){
    composable(
        Routes.DetailTest.route,
        arguments = Routes.DetailTest.navArg()
    ){
        val viewModel = hiltViewModel<DetailTestViewModel>()
        ScreenDetailTest(
            onStartTest = {
                router.navigate(Routes.Test.navigate(it))
            }
        )
    }
}