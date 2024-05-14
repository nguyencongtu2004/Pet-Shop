package com.example.petshop

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.petshop.model.Notification
import com.example.petshop.model.Product
import com.example.petshop.ui.TopAppBarNoSearch
import com.example.petshop.ui.TopAppBarWithSearch
import com.example.petshop.ui.home.HomeScreen
import com.example.petshop.ui.notification.NotificationScreen



enum class PetShopScreen() {
    HomePage(),
    NotificationScreen()

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
        Product(
            name = "Đồ ăn",
            description = "Cho chó",
            price = 12000.0,
            oldPrice = 9999999.0,
            star = 4.5,
            quantity = 1,
        ),
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
        Notification(
            title = "JACK",
            description = "5 củ",
            image = painterResource(id = R.drawable.notiication_bell)
        ),
        Notification(
            title = "JACK",
            description = "5 củ",
            image = painterResource(id = R.drawable.notiication_bell)
        ),
        Notification(
            title = "JACK",
            description = "5 củ",
            image = painterResource(id = R.drawable.notiication_bell)
        ),
        Notification(
            title = "JACK",
            description = "5 củ",
            image = painterResource(id = R.drawable.notiication_bell)
        ),
        Notification(
            title = "JACK",
            description = "5 củ",
            image = painterResource(id = R.drawable.notiication_bell)
        ),
    )


    // TRẠNG THÁI CỦA MÀN HÌNH Ở ĐÂY!!!!!!!!!!!!!!!

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = PetShopScreen.valueOf(backStackEntry?.destination?.route ?: PetShopScreen.HomePage.name)

    var selectedTabIndex by remember { mutableStateOf(0) } // Chọn tab "Đang giao" hoặc "Đã giao"
    var searchText by remember { mutableStateOf("") }

    var isSearchBarVisible by remember { mutableStateOf(true) }


    Scaffold(
        topBar = {
            if (isSearchBarVisible)
                TopAppBarWithSearch(
                    onSearchTextChanged = { text -> searchText = text },
                    onSearchIconClicked = { /*TODO*/ },
                    filterClicked = { /*TODO*/ },
                    notificationClicked = {
                        isSearchBarVisible = false
                        navController.navigate(PetShopScreen.NotificationScreen.name)
                                          },
                    cartClicked = { /*TODO*/ },
                    searchText = searchText,
                )
            else
                TopAppBarNoSearch(
                    title = currentScreen.name,
                    onBackClick = {
                        isSearchBarVisible = true
                        navController.popBackStack()
                    }
                )
        },
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
                    //thirdTabProduct = products,
                )
            }

            // Màn hình thông báo
            composable(route = PetShopScreen.NotificationScreen.name) {
                NotificationScreen(notifications = notifications)
            }
        }
    }
}

@Preview
@Composable
fun PetShopAppPreview() {
    PetShopApp()
}