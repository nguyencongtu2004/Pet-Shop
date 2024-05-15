package com.example.petshop

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Notification
import com.example.petshop.model.Product
import com.example.petshop.model.User
import com.example.petshop.ui.PetShopNavigationBar
import com.example.petshop.ui.TopAppBarNoSearch
import com.example.petshop.ui.TopAppBarWithSearch
import com.example.petshop.ui.checkout.CheckOutScreen
import com.example.petshop.ui.home.HomeScreen
import com.example.petshop.ui.notification.NotificationScreen
import com.example.petshop.ui.shipping_cart.ShoppingCartScreen
import com.example.petshop.ui.user_informaion.EditProfile
import com.example.petshop.ui.user_informaion.ProfileScreen

enum class PetShopScreen {
    HomePage,
    NotificationScreen,
    ShoppingCartScreen,
    ProfileScreen,

    // Các màn hình trong trang Profile
    EditProfileScreen,

    // Các màn hình thanh toán
    CheckOutScreen
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

    // TRẠNG THÁI CỦA MÀN HÌNH Ở ĐÂY
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        PetShopScreen.valueOf(backStackEntry?.destination?.route ?: PetShopScreen.HomePage.name)

    var selectedTabIndex by rememberSaveable { mutableStateOf(0) } // Chọn tab "Đang giao" hoặc "Đã giao"
    var searchText by rememberSaveable { mutableStateOf("") }

    var isSearchBarVisible by rememberSaveable { mutableStateOf(true) }
    var isNavigationBarVisible by rememberSaveable { mutableStateOf(true) }
    var selectedIndex = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            if (isSearchBarVisible)
                TopAppBarWithSearch(
                    onSearchTextChanged = { text -> searchText = text },
                    onSearchIconClicked = { /*TODO*/ },
                    filterClicked = { /*TODO*/ },
                    notificationClicked = {
                        isSearchBarVisible = false
                        isNavigationBarVisible = false
                        navController.navigate(PetShopScreen.NotificationScreen.name)
                    },
                    cartClicked = {
                        isSearchBarVisible = false
                        isNavigationBarVisible = false
                        navController.navigate(PetShopScreen.ShoppingCartScreen.name)
                    },
                    searchText = searchText,
                )
            else
                TopAppBarNoSearch(
                    title = currentScreen.name,
                    onBackClick = {
                        isSearchBarVisible = true
                        isNavigationBarVisible = true
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
                        if (currentScreen != PetShopScreen.HomePage)
                            navController.navigate(PetShopScreen.HomePage.name)
                    },
                    onChatClick = { /*TODO*/ },
                    onUserClick = {
                        if (currentScreen != PetShopScreen.ProfileScreen)
                            navController.navigate(PetShopScreen.ProfileScreen.name)
                    },
                )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = PetShopScreen.HomePage.name, // Màn hình bắt đầu
            modifier = Modifier.padding(innerPadding),
        ) {
            // Màn hình chính
            composable(route = PetShopScreen.HomePage.name) {
                HomeScreen(
                    products = products,
                    bannerItems = bannerItems,
                    onProductClick = { /*TODO*/ },
                    firstTabProduct = products,
                    secondTabProduct = products,
                )
            }

            // Màn hình thông báo
            composable(route = PetShopScreen.NotificationScreen.name) {
                NotificationScreen(notifications = notifications)
            }

            // Màn hình giỏ hàng
            composable(route = PetShopScreen.ShoppingCartScreen.name) {
                ShoppingCartScreen(
                    products = productsInCart,
                    onBuyClicked = {
                        isSearchBarVisible = false
                        isNavigationBarVisible = false
                        navController.navigate(PetShopScreen.CheckOutScreen.name)
                                   },
                )
            }

            // Màn hình thông tin cá nhân
            composable(route = PetShopScreen.ProfileScreen.name) {
                ProfileScreen(
                    user = loginedUser,
                    onEditProfileClicked = {
                        navController.navigate(PetShopScreen.EditProfileScreen.name)
                        isSearchBarVisible = false
                        isNavigationBarVisible = false
                    },
                )
            }

            // Các màn hình trong trang Profile
            composable(route = PetShopScreen.EditProfileScreen.name) {
                EditProfile(
                    user = loginedUser,
                )
            }

            // Các màn hình thanh toán
            composable(route = PetShopScreen.CheckOutScreen.name) {
                CheckOutScreen()
            }
        }
    }
}

@Preview
@Composable
fun PetShopAppPreview() {
    PetShopApp()
}
