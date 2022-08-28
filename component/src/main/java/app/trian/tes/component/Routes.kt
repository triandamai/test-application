package app.trian.tes.component

import androidx.navigation.NavType
import androidx.navigation.navArgument

object Routes {
    const val Splash = "SplashScreen"
    const val Onboard ="OnboardScreen"
    const val ResetPassword = "ResetPasswordScreen"
    const val Login = "Login"
    const val Register = "Register"

    object DetailTest{
        const val argKey = "slug"
        const val route = "DetailTest/{$argKey}"
        fun navArg()=listOf(navArgument(argKey) { type = NavType.StringType })
        fun navigate(arg:String) = "DetailTest/$arg"
    }
    object Test{
        const val argKey = "slug"
        const val route = "Test/{$argKey}"
        fun navArg()=listOf(navArgument(argKey) { type = NavType.StringType })
        fun navigate(arg:String) = "Test/$arg"
    }
    object FinishTest{
        const val argKey = "slug"
        const val route = "FinishTest/{$argKey}"
        fun navArg()=listOf(navArgument(argKey) { type = NavType.StringType })
        fun navigate(arg:String) = "FinishTest/$arg"
    }

    object Main{
        const val MAIN = "MAIN"
        const val Home = "Home"
        const val Profile = "Profile"
    }

}