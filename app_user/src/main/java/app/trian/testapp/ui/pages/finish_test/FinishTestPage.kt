package app.trian.testapp.ui.pages.finish_test

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.ScreenFinishTest
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeFinishTest(router:NavHostController){
    composable(
        Routes.FinishTest.route,
        arguments = Routes.FinishTest.navArg()
    ){
        val viewModel = hiltViewModel<FinishTestViewModel>()
        ScreenFinishTest(

        )
    }
}