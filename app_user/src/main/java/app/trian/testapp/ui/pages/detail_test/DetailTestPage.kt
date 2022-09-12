package app.trian.testapp.ui.pages.detail_test

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.DetailTestUIState
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
        val uiState by viewModel.detailTest.observeAsState(initial = DetailTestUIState(
            loading = true,
            error = false
        ))
        ScreenDetailTest(
            uiState = uiState,
            onStartTest = {
                router.navigate(Routes.Test.navigate(it))
            }
        )
    }
}