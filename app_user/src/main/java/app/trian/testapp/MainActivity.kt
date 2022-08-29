package app.trian.testapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import app.trian.tes.component.Routes
import app.trian.tes.component.theme.TestTheme
import app.trian.testapp.ui.pages.detail_test.routeDetailTest
import app.trian.testapp.ui.pages.finish_test.routeFinishTest
import app.trian.testapp.ui.pages.login.routeLogin
import app.trian.testapp.ui.pages.main.routeHome
import app.trian.testapp.ui.pages.main.routeProfile
import app.trian.testapp.ui.pages.onboard.routeOnboard
import app.trian.testapp.ui.pages.register.routerRegister
import app.trian.testapp.ui.pages.reset_password.routeResetPassword
import app.trian.testapp.ui.pages.splash.routeSplash
import app.trian.testapp.ui.pages.test.routeTest
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


/**
 * Main Activity
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 28/08/2021
 **/



@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val router = rememberAnimatedNavController()

            //make status bar custom color
            val systemUiController = rememberSystemUiController()

            fun setStatusBar(color: Color, isDark:Boolean){
                systemUiController.setStatusBarColor(
                    color=color,
                    darkIcons = isDark
                )
            }
            val status = MaterialTheme.colors.background

            LaunchedEffect(key1 = Unit, block = {
                setStatusBar(status,true)
            })
            TestTheme {
                    AnimatedNavHost(
                        navController = router,
                        startDestination = Routes.Splash
                    ) {
                        routeSplash(router)
                        routeOnboard(router)
                        routeResetPassword(router)
                        routeLogin(router)
                        routerRegister(router)
                        navigation(
                            route = Routes.Main.MAIN,
                            startDestination = Routes.Main.Home
                        ){
                            routeHome(router)
                            routeProfile(router)
                        }
                        routeDetailTest( router)
                        routeTest(router)
                        routeFinishTest(router)
                    }
            }
        }
    }

    fun restart(){
        Intent(this,MainActivity::class.java).apply {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }.also {
            startActivity(it)
            finish()
        }
    }

}

