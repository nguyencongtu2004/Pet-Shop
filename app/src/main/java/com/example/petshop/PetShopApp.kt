package com.example.petshop


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.petshop.model.Flavor
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Screen
import com.example.petshop.model.Weight
import com.example.petshop.ui.PetShopNavigationBar
import com.example.petshop.ui.TopAppBarNoSearch
import com.example.petshop.ui.TopAppBarWithSearch
import com.example.petshop.ui.chat.ChatScreen
import com.example.petshop.ui.checkout.CheckoutScreen
import com.example.petshop.ui.checkout.LoadingScreen
import com.example.petshop.ui.checkout.SelectPayMethod
import com.example.petshop.ui.checkout.SelectVoucher
import com.example.petshop.ui.checkout.TransactionScreen
import com.example.petshop.ui.home.HomeScreen
import com.example.petshop.ui.login_register.Login
import com.example.petshop.ui.login_register.Register
import com.example.petshop.ui.notification.NotificationScreen
import com.example.petshop.ui.product_infor.ProductDetail
import com.example.petshop.ui.shipment.FollowShippingScreen
import com.example.petshop.ui.shipment.ShipmentStateScreen
import com.example.petshop.ui.shipping_cart.ShoppingCartScreen
import com.example.petshop.ui.user_informaion.EditProfile
import com.example.petshop.ui.user_informaion.ProfileScreen
import com.example.petshop.view_model.BannerViewModel
import com.example.petshop.view_model.CartViewModel
import com.example.petshop.view_model.ChatViewModel
import com.example.petshop.view_model.NotificationViewModel
import com.example.petshop.view_model.OrderViewModel
import com.example.petshop.view_model.ProductViewModel
import com.example.petshop.view_model.UserViewModel

val NavHostController.canGoBack: Boolean
    get() = this.previousBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

fun NavHostController.navigateBack() {
    if (canGoBack) {
        this.popBackStack()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PetShopApp(
    navController: NavHostController = rememberNavController(),
) {
    // VIEW MODEL Ở ĐÂY
    val userViewModel = viewModel<UserViewModel>()
    val cartViewModel = viewModel<CartViewModel>()
    val productViewModel = viewModel<ProductViewModel>()
    val notificationViewModel = viewModel<NotificationViewModel>()
    val bannerViewModel = viewModel<BannerViewModel>()
    val orderViewModel = viewModel<OrderViewModel>()
    val chatViewModel = viewModel<ChatViewModel>()

    // TRẠNG THÁI CỦA MÀN HÌNH Ở ĐÂY

    // Lấy màn hình hiện tại
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: Screen.HomePage.route

    // Get the current screen object based on the route
    val currentScreenObject = Screen::class.sealedSubclasses
        .mapNotNull { it.objectInstance }
        .find { it.route == currentScreen }

    // Tìm kiếm
    var searchText by rememberSaveable { mutableStateOf("") }

    // Các trạng thái của các phần tử giao diện
    var isSearchBarVisible by rememberSaveable { mutableStateOf(true) }
    var isNoSearchBarVisible by rememberSaveable { mutableStateOf(true) }
    var isNavigationBarVisible by rememberSaveable { mutableStateOf(true) }
    var selectedIndex = remember { mutableStateOf(0) }

    // Cập nhật trạng thái khi currentScreen thay đổi (chạy đoạn code dưới sau mỗi lần currentScreen thay đổi)
    LaunchedEffect(currentScreen) {
        when (currentScreen) {
            Screen.HomePage.route -> selectedIndex.value = 0
            Screen.ProfileScreen.route -> selectedIndex.value = 2
        }

        when (currentScreen) {
            Screen.HomePage.route, Screen.ProfileScreen.route -> {
                isSearchBarVisible = true
                isNoSearchBarVisible = false
                isNavigationBarVisible = true
            }

            Screen.LoadingCheckout.route, Screen.TransactionScreen.route, Screen.ProductDetailScreen.route, Screen.LoginScreen.route, Screen.RegisterScreen.route, Screen.ChatScreen.route -> {
                isSearchBarVisible = false
                isNoSearchBarVisible = false
                isNavigationBarVisible = false
            }

            else -> {
                isSearchBarVisible = false
                isNoSearchBarVisible = true
                isNavigationBarVisible = false
            }
        }
    }

    Scaffold(
        topBar = {
            if (isSearchBarVisible)
                TopAppBarWithSearch(
                    onSearchTextChanged = { text -> searchText = text },
                    onSearchIconClicked = { /*TODO*/ },
                    filterClicked = { /*TODO*/ },
                    notificationClicked = {
                        navController.navigate(Screen.NotificationScreen.route)
                    },
                    cartClicked = {
                        navController.navigate(Screen.ShoppingCartScreen.route)
                    },
                    searchText = searchText,
                )
            if (isNoSearchBarVisible)
                TopAppBarNoSearch(
                    title = currentScreenObject?.title ?: "",
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
        },
        bottomBar = {
            if (isNavigationBarVisible)
                PetShopNavigationBar(
                    selectedIndex = selectedIndex.value,
                    updateIndex = { selectedIndex.value = it },
                    onHomeClick = {
                        if (currentScreen != Screen.HomePage.route) {
                            // Xóa hết ngăn xếp chừa HomePage
                            navController.navigate(Screen.HomePage.route) {
                                popUpTo(Screen.HomePage.route) { inclusive = true }
                            }
                        }
                    },
                    onChatClick = {
                        navController.navigate(Screen.ChatScreen.route)
                    },
                    onUserClick = {
                        if (currentScreen != Screen.ProfileScreen.route) {
                            navController.navigate(Screen.ProfileScreen.route) {
                                popUpTo(Screen.HomePage.route) { inclusive = false }
                            }
                        }
                    },
                )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            // Nơi bắt đầu của ứng dụng
            startDestination = Screen.HomePage.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            // Màn hình chính
            composable(route = Screen.HomePage.route) {
                HomeScreen(
                    navController = navController,
                    productViewModel = productViewModel,
                    bannerViewModel = bannerViewModel,
                    onProductClick = {productId ->
                        navController.navigate(Screen.ProductDetailScreen.createRoute(productId))
                    }
                )
            }

            // Màn hình thông tin cá nhân
            composable(route = Screen.ProfileScreen.route) {
                ProfileScreen(
                    navController = navController,
                    userViewModel = userViewModel,
                    onEditProfileClicked = {
                        navController.navigate(Screen.EditProfileScreen.route)
                    },
                    onShippingClicked = {
                        navController.navigate(Screen.ShipmentStateScreen1.route)
                    },
                    onShippedClicked = {
                        navController.navigate(Screen.ShipmentStateScreen2.route)
                    }
                )
            }

            // Màn hình thông báo
            composable(route = Screen.NotificationScreen.route) {
                NotificationScreen(notificationViewModel = notificationViewModel)
            }

            // Màn hình giỏ hàng
            composable(route = Screen.ShoppingCartScreen.route) {
                ShoppingCartScreen(
                    navController = navController, // Để điều hướng sang màn hình thanh toán
                    cartViewModel = cartViewModel
                )
            }

            // Màn hình thanh toán
            composable(route = Screen.CheckoutScreen.route) { //backStackEntry ->
                CheckoutScreen(
                    navController = navController,
                    cartViewModel = cartViewModel,
                    orderViewModel = orderViewModel,
                    userViewModel = userViewModel
                )
            }

            // Các màn hình trong trang Profile
            composable(route = Screen.EditProfileScreen.route) {
                EditProfile(
                    navController = navController,
                    userViewModel = userViewModel,
                )
            }

            composable(route = Screen.ShipmentStateScreen1.route) {
                ShipmentStateScreen(
                    selectTabIndex = 0,
                    navController = navController,
                    orderViewModel = orderViewModel,
                )
            }

            composable(route = Screen.ShipmentStateScreen2.route) {
                ShipmentStateScreen(
                    selectTabIndex = 1,
                    navController = navController,
                    orderViewModel = orderViewModel,
                )
            }

            composable(route = Screen.LoadingCheckout.route) {
                LoadingScreen(navController = navController)
            }

            composable(route = Screen.TransactionScreen.route) {
                TransactionScreen(
                    navController = navController,
                    orderViewModel = orderViewModel
                )
            }

            composable(
                route = Screen.FollowShipping.route,
                arguments = listOf(navArgument("orderId") {
                    type = NavType.StringType;
                    defaultValue = "no_id"
                    nullable = true
                })
            ) { backStackEntry ->
                val orderId = backStackEntry.arguments?.getString("orderId")
                FollowShippingScreen(
                    orderViewModel = orderViewModel,
                    orderId = orderId!!
                )
            }

            composable(route = Screen.SelectPayMethod.route) {
                SelectPayMethod(
                    orderViewModel = orderViewModel,
                )
            }

            composable(route = Screen.SelectVoucher.route) {
                SelectVoucher(
                    navController = navController,
                    onSearchVoucher = { /*TODO*/ }
                )
            }

            composable(
                route = Screen.ProductDetailScreen.route,
                arguments = listOf(navArgument("productId") {
                    type = NavType.StringType;
                    defaultValue = "no_id"
                    nullable = true
                })
            ) {backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")

                ProductDetail(
                    navController = navController,
                    productId = productId!!,
                    productViewModel = productViewModel,
                    userViewModel = userViewModel,
                    cartViewModel = cartViewModel,
                    orderViewModel = orderViewModel,
                )
            }

            composable(route = Screen.LoginScreen.route) {
                Login(
                    navController = navController
                )
            }

            composable(route = Screen.RegisterScreen.route) {
                Register(
                    navController = navController
                )
            }

            composable(route = Screen.ChatScreen.route) {
                ChatScreen(
                    navController = navController,
                    chatViewModel = chatViewModel,
                )
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PetShopAppPreview() {
    PetShopApp()
}

