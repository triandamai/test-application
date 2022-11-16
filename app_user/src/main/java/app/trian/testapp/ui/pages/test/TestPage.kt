package app.trian.testapp.ui.pages.test

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.ScreenQuestion
import app.trian.tes.component.utils.toastError
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeTest(
    router:NavHostController
){
    composable(
        Routes.Test.route,
        arguments = Routes.Test.navArg()
    ){
        val viewModel = hiltViewModel<TestViewModel>()
        val ctx = LocalContext.current
        var currentPage by rememberSaveable {
            mutableStateOf(1)
        }
        var totalPage = 10
        ScreenQuestion(
            currentPage=currentPage,
            totalPage = totalPage,
            onBackPressed = {},
            onNext = {
                if(currentPage == 10){
                    //submit
                    ctx.toastError("Test submit")
                }else{
                    if(currentPage < totalPage){
                        currentPage += 1
                    }
                }
            },
            onPrev = {
                if(currentPage >= 1){
                    currentPage -=1
                }
            }
        )
    }
}