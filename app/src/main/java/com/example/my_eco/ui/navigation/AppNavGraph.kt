package com.example.my_eco.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eclipse.findz.screen.RegisterUmkmScreen
import com.example.findz.InfluencerDetailScreen
import com.example.my_eco.R
import com.example.my_eco.data.repository.UserRepository
import com.example.my_eco.ui.screen.chat.ChatScreen
import com.example.my_eco.ui.screen.chat.UserListScreen
import com.example.my_eco.ui.screen.login.LoginScreen
import com.example.my_eco.ui.screen.login.LoginViewModel
import com.example.my_eco.ui.screen.home.HomeScreen
import com.example.my_eco.ui.screen.influencer.InfluencerHeader
import com.example.my_eco.ui.screen.influencer.SearchInfluencerScreen
import com.example.my_eco.ui.screen.login.RegisterInfluencerScreen
import com.example.my_eco.ui.screen.login.RegisterScreen
import com.example.my_eco.ui.screen.order.OrderPageItem
import com.example.my_eco.ui.screen.order.OrderScreenIdentity
import com.example.my_eco.ui.screen.order.OrderSummaryScreen
import com.example.my_eco.ui.screen.user.UserScreen
import com.example.my_eco.ui.tutorial.TutorialScreen1
import com.example.my_eco.ui.tutorial.TutorialScreen2
import com.example.my_eco.ui.tutorial.TutorialScreen3
import com.example.my_eco.ui.tutorial.TutorialScreen4
import com.example.my_eco.ui.tutorial.TutorialScreen5

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object User : Screen("user")
    object ChatDetail : Screen("chat_detail/{chatId}/{userName}") { // Tambahkan userName ke rute
        fun createRoute(chatId: String, userName: String) = "chat_detail/$chatId/$userName"
    }
    object UserList : Screen("user_list") // Layar daftar pengguna

    object OrderIndent : Screen("order/{influId}/{usernameInflu}")
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val userRepository: UserRepository = loginViewModel.repository // Ambil UserRepository dari LoginViewModel
    val currentUserId = userRepository.getCurrentUser()?.id

    NavHost(
        navController = navController,
        startDestination = if (!currentUserId.isNullOrEmpty()) Screen.Home.route else Screen.Login.route

    ) {
        // Login Screen


        // Home Screen
        composable(route = Screen.Home.route) {
            HomeScreen(
                onNavigateToUser = { navController.navigate(Screen.User.route) },
                onNavigateToUserList = { navController.navigate(Screen.UserList.route) },
                onNavigateToOrderIndent = {navController.navigate(Screen.OrderIndent.route)},
                onNavigateToInflu = {navController.navigate("serchInfluencer")},

            )
        }

        // User Profile Screen
        composable(route = Screen.User.route) {
            UserScreen(
                onLogout = { navController.popBackStack(Screen.Login.route, inclusive = true) }
            )
        }

        // User List Screen
        composable(route = Screen.UserList.route) {
            UserListScreen(
                onUserClick = { userId, userName,->
                    val currentUserIdC = userRepository.getCurrentUser()?.id ?: "none"
                    val chatId = generateChatId(currentUserIdC ,userId)
                    navController.navigate(Screen.ChatDetail.createRoute(chatId, userName))
                }
            )
        }

        // Chat Detail Screen
        composable(route = Screen.ChatDetail.route) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            val userName = backStackEntry.arguments?.getString("userName") ?: "Unknown"
//            val currentUserId = userRepository.getCurrentUser()?.id

            if (currentUserId != null) {
                ChatScreen(
                    chatId = chatId,
                    userId = currentUserId,
                    nameDesti = userName,
                    navController = navController
                )
            } else {
                navController.navigate(Screen.Login.route) // Jika user tidak valid
            }
        }

        composable(route = Screen.OrderIndent.route) { backStackEntry ->
            val influId = backStackEntry.arguments?.getString("influId") ?: ""
            val userNameInflu = backStackEntry.arguments?.getString("usernameInflu") ?: "Unknown"
//            val currentUserId = userRepository.getCurrentUser()?.id

            if (currentUserId != null) {
                OrderScreenIdentity(
                    influId = influId,
                    usernameInflu = userNameInflu,
                    userCurrentId = currentUserId,
                    navController = navController,
                    onNextClick = { navController.navigate("orderDetail") },
                )
            } else {
                navController.navigate(Screen.Home.route) // Jika user tidak valid
            }
        }

        composable("registerumkm") { RegisterUmkmScreen(navController = navController)}
        composable("registerinfluencer") { RegisterInfluencerScreen(navController = navController)}
        composable("login") { LoginScreen(navController = navController)}
        composable("register") { RegisterScreen(navController = navController) }
        composable("tutorial1") { TutorialScreen1(navController = navController) }
        composable("tutorial2") { TutorialScreen2(navController = navController) }
        composable("tutorial3") { TutorialScreen3(navController = navController) }
        composable("tutorial4") { TutorialScreen4(navController = navController) }
        composable("tutorial5") { TutorialScreen5(navController = navController) }

        composable("orderDetail") { OrderPageItem(navController = navController, onUploadClick = { println("Upload clicked") }, onNextClick = { navController.navigate("orderSummary") }) }
        composable("orderSummary") { OrderSummaryScreen(navController = navController) { println() } }
        composable("serchInfluencer") { SearchInfluencerScreen(navController = navController)  }
        composable("influencer_card/Nanda Arsyinta") { InfluencerDetailScreen(
            navController = navController,
            influencerName = "Nanda Arsyinta",
        )  }
        composable("influencer_card_header/Nanda Arsyinta") { InfluencerHeader(
            imageResId = R.drawable.influencer_image,
        )  }



    } }

fun generateChatId(userId1: String, userId2: String): String {
    val concatenatedId = if (userId1 < userId2) {
        "$userId1$userId2"
    } else {
        "$userId2$userId1"
    }
    return concatenatedId.hashCode().toString()
}