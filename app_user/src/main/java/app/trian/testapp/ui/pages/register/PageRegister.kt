package app.trian.testapp.ui.pages.register

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.dialog.DialogLoading
import app.trian.tes.component.screen.ScreenRegister
import app.trian.tes.component.utils.toastError
import app.trian.tes.component.utils.toastSuccess
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routerRegister(
    router: NavHostController
) {
    composable(Routes.Register) {
        val viewModel = hiltViewModel<RegisterViewModel>()
        val ctx = LocalContext.current

        var loading by remember {
            mutableStateOf(false)
        }

        DialogLoading(show = loading)

        ScreenRegister(
            onRegister = {
                email,password,name->
                loading = true

                viewModel.register(
                    email,
                    password,
                    name
                ){
                    success,message->
                    loading = false
                    if(success){
                        ctx.toastSuccess(message)
                        router.navigate(Routes.Main.MAIN){
                            popUpTo(Routes.Login){
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }else{
                        ctx.toastError(message)
                    }
                }

            },
            onLogin = {
                router.popBackStack()
            }
        )
    }
}
