package com.example.petshop

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Notification
import com.example.petshop.model.Screen
import com.example.petshop.model.Product
import com.example.petshop.model.User
import com.example.petshop.ui.PetShopNavigationBar
import com.example.petshop.ui.TopAppBarNoSearch
import com.example.petshop.ui.TopAppBarWithSearch
import com.example.petshop.ui.checkout.CheckoutScreen
import com.example.petshop.ui.home.HomeScreen
import com.example.petshop.ui.notification.NotificationScreen
import com.example.petshop.ui.shipping_cart.ShoppingCartScreen
import com.example.petshop.ui.user_informaion.EditProfile
import com.example.petshop.ui.user_informaion.ProfileScreen

// Hàm điều hướng tới màn hình mới và loại bỏ màn hình hiện tại khỏi ngăn xếp
fun navigateAndReplace(navController: NavController, route: String) {
    navController.navigate(route) {
        popUpTo(navController.graph.startDestinationId) {
            inclusive = true
        }
    }
}

@Composable
fun PetShopApp(
    navController: NavHostController = rememberNavController()
) {
    // DỮ LIỆU GIẢ CỦA ỨNG DỤNG tại đây
    val products = listOf(
        Product(
            name = "Đồ ăn",
            description = "Cho chó",
            price = 12000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
        // Thêm các sản phẩm khác ở đây...
    )
    val bannerItems = listOf(
        painterResource(id = R.drawable.banner),
        painterResource(id = R.drawable.banner),
        painterResource(id = R.drawable.banner),
    )
    val notifications = listOf(
        Notification(
            title = "JACK",
            description = "5 củ",
            image = painterResource(id = R.drawable.notiication_bell)
        ),
        // Thêm các thông báo khác ở đây...
    )
    val productsInCart = listOf(
        FoodProduct(
            name = "Thức ăn",
            description = "Cho chó",
            price = 12000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
            weight = 1.5,
            type = "Thức ăn khô",
        ),
        // Thêm các sản phẩm khác ở đây...
    )
    val loginedUser = User(
        name = "Võ Hoàng Tuấn",
        role = "Khách hàng thân thiết",
        favoriteProducts = listOf(),
        sex = "Nam",
        email = "asdfsaf@asadfs.fff",
        phone = "0123456789",
        avatar = painterResource(id = R.drawable.avatar),
        birthday = "01/01/2000",
        password = "password",
        address = "đâu đó",
    )
    val productsToBuy: List<Product> = mutableListOf<Product>()

    // TRẠNG THÁI CỦA MÀN HÌNH Ở ĐÂY
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: Screen.HomePage.route

    var selectedTabIndex by rememberSaveable { mutableStateOf(0) } // Chọn tab "Đang giao" hoặc "Đã giao"
    var searchText by rememberSaveable { mutableStateOf("") }

    var isSearchBarVisible by rememberSaveable { mutableStateOf(true) }
    var isNavigationBarVisible by rememberSaveable { mutableStateOf(true) }
    val selectedIndex = remember { mutableStateOf(0) }



    // Cập nhật trạng thái khi currentScreen thay đổi (chạy đoạn code dưới sau mỗi lần currentScreen thay đổi)
    LaunchedEffect(currentScreen) {
        when (currentScreen) {
            Screen.HomePage.route, Screen.ProfileScreen.route -> {
                isSearchBarVisible = true
                isNavigationBarVisible = true
            }
            else -> {
                isSearchBarVisible = false
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
            else
                TopAppBarNoSearch(
                    title = currentScreen,
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
                            navController.navigate(Screen.HomePage.route) {
                                popUpTo(Screen.HomePage.route) { inclusive = true }
                            }
                        }
                    },
                    onChatClick = { /*TODO*/ },
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
            startDestination = Screen.HomePage.route, // Màn hình bắt đầu
            modifier = Modifier.padding(innerPadding),
        ) {
            // Màn hình chính
            composable(route = Screen.HomePage.route) {
                HomeScreen(
                    navController = navController,
                    products = products,
                    bannerItems = bannerItems,
                    onProductClick = { /*TODO*/ },
                    firstTabProduct = products,
                    secondTabProduct = products,
                )
            }

            // Màn hình thông tin cá nhân
            composable(route = Screen.ProfileScreen.route) {
                ProfileScreen(
                    navController = navController,
                    user = loginedUser,
                    onEditProfileClicked = {
                        navController.navigate(Screen.EditProfileScreen.route)

                    },
                )
            }





            // Màn hình thông báo
            composable(route = Screen.NotificationScreen.route) {
                NotificationScreen(
                    navController = navController,
                    notifications = notifications
                )
            }

            // Màn hình giỏ hàng
            composable(route = Screen.ShoppingCartScreen.route) {
                ShoppingCartScreen(
                    products = productsInCart,
                    onBuyClicked = {
                        navController.navigate(Screen.CheckoutScreen.route)
                    },

                )
            }

            // Các màn hình thanh toán
            composable(route = Screen.CheckoutScreen.route) {
                CheckoutScreen(
                    products = productsInCart
                )
            }



            // Các màn hình trong trang Profile
            composable(route = Screen.EditProfileScreen.route) {
                EditProfile(
                    user = loginedUser,
                )
            }




        }
    }
}

@Preview
@Composable
fun PetShopAppPreview() {
    PetShopApp()
}
