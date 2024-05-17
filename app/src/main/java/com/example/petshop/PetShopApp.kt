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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.petshop.view_model.CartViewModel
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Notification
import com.example.petshop.model.Product
import com.example.petshop.model.Screen
import com.example.petshop.model.User
import com.example.petshop.ui.PetShopNavigationBar
import com.example.petshop.ui.TopAppBarNoSearch
import com.example.petshop.ui.TopAppBarWithSearch
import com.example.petshop.ui.checkout.CheckoutScreen
import com.example.petshop.ui.checkout.LoadingScreen
import com.example.petshop.ui.checkout.SelectPayMethod
import com.example.petshop.ui.checkout.SelectVoucher
import com.example.petshop.ui.checkout.TransactionScreen
import com.example.petshop.ui.home.HomeScreen
import com.example.petshop.ui.notification.NotificationScreen
import com.example.petshop.ui.product_infor.ProDuctDetail
import com.example.petshop.ui.shipment.FollowShippingScreen
import com.example.petshop.ui.shipment.ShipmentStateScreen
import com.example.petshop.ui.shipping_cart.ShoppingCartScreen
import com.example.petshop.ui.user_informaion.EditProfile
import com.example.petshop.ui.user_informaion.ProfileScreen

//import com.google.common.reflect.TypeToken
//import com.google.gson.Gson

@Composable
fun PetShopApp(
    navController: NavHostController = rememberNavController(),
    cartViewModel: CartViewModel = viewModel()
) {
    // DỮ LIỆU GIẢ CỦA ỨNG DỤNG tại đây
    val shippingProducts = listOf(
        FoodProduct(
            name = "Thức ăn hạt mềm Zenith",
            description = "Nổi tiếng với đồ ăn cho chó con được yêu thích",
            price = 90000.0,
            quantity = 1,
            image = painterResource(id = R.drawable.avt),
            flavor = "Cá hồi",
            weight = 0.5
        ),
        FoodProduct(
            name = "Thức ăn hạt mềm Zenith",
            description = "Nổi tiếng với đồ ăn cho chó con được yêu thích",
            price = 90000.0,
            quantity = 1,
            image = painterResource(id = R.drawable.avt),
            flavor = "Cá hồi",
            weight = 0.5
        )
    )
    val shippedProducts = listOf(
        FoodProduct(
            name = "Thức ăn hạt mềm Zenith",
            description = "Nổi tiếng với đồ ăn cho chó con được yêu thích",
            price = 90000.0,
            quantity = 1,
            image = painterResource(id = R.drawable.avt),
            flavor = "Cá hồi",
            weight = 0.5
        )
    )
    val products = listOf(
        Product(
            name = "Đồ ăn",
            description = "Cho chó",
            price = 12000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
        Product(
            name = "Đồ ăn",
            description = "Cho chó",
            price = 12000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
        Product(
            name = "Đồ ăn",
            description = "Cho chó",
            price = 12000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
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
            flavor = "Thức ăn khô",
        ),
        FoodProduct(
            name = "Thức ăn 2",
            description = "Cho chó nhỏ",
            price = 2000.0,
            oldPrice = 9399.0,
            star = 4.5,
            quantity = 2,
            weight = 3.0,
            flavor = "Thức ăn khô",
        ),
        // Thêm các sản phẩm khác ở đây...
    )
    val loginedUser = User(
        name = "Nguyễn Công Tú",
        role = "Khách hàng thân thiết",
        favoriteProducts = listOf(),
        sex = "Nam",
        email = "asdfsaf@asadfs.fff",
        phone = "0123456789",
        avatar = painterResource(id = R.drawable.avatar),
        birthday = "01/01/2000",
        password = "null",
        address = "đâu đó",
    )
    val productsToBuy: List<Product> = mutableListOf<Product>(
        Product(
            name = "Thức ăn hạt mềm Zenith",
            description = "Nổi tiếng với đồ ăn cho chó con được yêu thích",
            price = 90000.0,
            quantity = 1,
            image = painterResource(id = R.drawable.avt),
        ),
        Product(
            name = "Thức ăn hạt mềm Zenith",
            description = "Nổi tiếng với đồ ăn cho chó con được yêu thích",
            price = 90000.0,
            quantity = 1,
            image = painterResource(id = R.drawable.avt),
        )
    )

    // TRẠNG THÁI CỦA MÀN HÌNH Ở ĐÂY
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: Screen.HomePage.route

    var selectedTabIndex by rememberSaveable { mutableStateOf(0) } // Chọn tab "Đang giao" hoặc "Đã giao"
    var searchText by rememberSaveable { mutableStateOf("") }

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

            Screen.LoadingCheckout.route, Screen.TransactionScreen.route, Screen.ProDuctDetail.route -> {
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
                            // Xóa hết ngăn xếp chừa HomePage
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
                    firstTabProduct = products,
                    secondTabProduct = listOf(
                        Product(
                            name = "Đồ ăn",
                            description = "Cho chó",
                            price = 12000.0,
                            oldPrice = 9999999.0,
                            star = 4.5,
                            quantity = 1,
                        ),
                        Product(
                            name = "Đồ ăn",
                            description = "Cho chó",
                            price = 12000.0,
                            oldPrice = 9999999.0,
                            star = 4.5,
                            quantity = 1,
                        ),


                        // Thêm các sản phẩm khác ở đây...
                    ),
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
                NotificationScreen(
                    navController = navController,
                    notifications = notifications
                )
            }

            // Màn hình giỏ hàng
            composable(route = Screen.ShoppingCartScreen.route) {
                ShoppingCartScreen(
                    navController = navController, // Để điều hướng sang màn hình thanh toán
                    products = productsInCart,
                    cartViewModel = cartViewModel
                )
            }

            // Màn hình thanh toán
            composable(route = Screen.CheckoutScreen.route) { //backStackEntry ->
                CheckoutScreen(
                    cartViewModel = cartViewModel,
                    navController = navController,
                )
            }


            // Các màn hình trong trang Profile
            composable(route = Screen.EditProfileScreen.route) {
                EditProfile(
                    user = loginedUser,
                )
            }

            composable(route = Screen.ShipmentStateScreen1.route) {
                ShipmentStateScreen(
                    selectTabIndex = 0,
                    shippingProducts = shippingProducts,
                    shippedProducts = shippedProducts
                )
            }

            composable(route = Screen.ShipmentStateScreen2.route) {
                ShipmentStateScreen(
                    selectTabIndex = 1,
                    shippingProducts = shippingProducts,
                    shippedProducts = shippedProducts
                )
            }

            composable(route = Screen.LoadingCheckout.route) {
                LoadingScreen(navController = navController)
            }

            composable(route = Screen.TransactionScreen.route) {
                TransactionScreen(navController = navController)
            }

            composable(route = Screen.FollowShipping.route) {
                FollowShippingScreen()
            }

            composable(route = Screen.SelectPayMethod.route) {
                SelectPayMethod(navController = navController)
            }

            composable(route = Screen.SelectVoucher.route) {
                SelectVoucher(
                    navController = navController,
                    onSearchVoucher = { /*TODO*/ }
                )
            }
            composable(route = Screen.ProDuctDetail.route) {
                ProDuctDetail(
                    navController = navController,
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
