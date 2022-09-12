package app.trian.testapp.ui.pages.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.main.HomeUIState
import app.trian.tes.component.screen.main.ScreenHome
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeHome(
    router: NavHostController
){
    composable(Routes.Main.Home){
        val viewModel = hiltViewModel<HomeViewModel>()
        val state by viewModel.listPemantau.observeAsState(
            initial = HomeUIState(
                loading = true,
                error = false
            )
        )
        ScreenHome(
            router = router,
            menus = listOf(),
            uiState = state,
            userName = "Trian",
            onDetailTest = {
                router.navigate(Routes.DetailTest.navigate(it)){
                    launchSingleTop = true
                }
            }
        )
    }
}