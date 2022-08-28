package app.trian.testapp.ui.pages.reset_password

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.trian.tes.component.Routes
import app.trian.tes.component.dialog.DialogLoading
import app.trian.tes.component.screen.ScreenResetPassword
import app.trian.tes.component.utils.toastError
import app.trian.tes.component.utils.toastSuccess
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.routeResetPassword(
    router: NavHostController
) {
    composable(Routes.ResetPassword) {
        val viewModel = hiltViewModel<ResetPasswordViewModel>()
        val ctx = LocalContext.current
        var loading by remember {
            mutableStateOf(false)
        }
        DialogLoading(show = loading)

        ScreenResetPassword(
           onSubmit = {
               loading = true
               viewModel.resetPassword(it){
                   success,message->
                   loading = false
                   if(success){
                       ctx.toastSuccess(message)
                       router.popBackStack()
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
