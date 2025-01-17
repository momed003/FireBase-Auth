package com.learn.signupfirebase.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.signupfirebase.ui.screen.login.AuthViewModel
import com.learn.signupfirebase.ui.screen.login.Login
import com.learn.signupfirebase.ui.screen.splash.FirstScreen
import com.learn.signupfirebase.ui.screen.splash.SplashScreen

sealed class Screen(val route: String) {
    object Splash : Screen("spash_screen")
    object FirstScreen : Screen("principal_screen")
    object Login : Screen("login_screen")
}


@Composable
fun AppHost(
    loginViewModel: AuthViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Splash"
    ) {

        //SPLASH AND LOGIN FLOW
        composable("Splash") {
            SplashScreen(navController)
        }

        composable(Screen.FirstScreen.route){
           FirstScreen(navController)
        }

        composable(Screen.Login.route) {
            Login(loginViewModel,navController)
        }

    }

}

