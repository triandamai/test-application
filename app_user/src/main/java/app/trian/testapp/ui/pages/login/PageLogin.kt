package app.trian.testapp.ui.pages.login

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.dialog.DialogLoading
import app.trian.tes.component.screen.ScreenLogin
import app.trian.tes.component.utils.toastError
import app.trian.tes.component.utils.toastSuccess
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeLogin(
    router: NavHostController
) {
    composable(Routes.Login) {
        val viewModel = hiltViewModel<LoginViewModel>()
        val ctx = LocalContext.current

        var loading by remember {
            mutableStateOf(false)
        }

        DialogLoading(show = loading)

        ScreenLogin(
            onSignIn = {
                email,password->
                loading = true

                viewModel.signIn(
                    email,password
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
            onSignUp = {
                       router.navigate(Routes.Register){
                           launchSingleTop = true
                       }
            },
            onResetPassword = {
                router.navigate(Routes.ResetPassword){
                    launchSingleTop=true
                }
            }
        )
    }
}
