package com.example.petshop.ui.shipment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petshop.R
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Order
import com.example.petshop.model.OrderStatus
import com.example.petshop.model.Product
import com.example.petshop.model.Screen
import com.example.petshop.ui.checkout.CheckoutItem
import com.example.petshop.ui.theme.PetShopTheme
import com.example.petshop.view_model.OrderViewModel

@Composable
fun ShipmentStateScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    orderViewModel: OrderViewModel,
    selectTabIndex: Int = 0,
) {
    val allOrders by orderViewModel.allOrders.collectAsState()

    var selectedTabIndex by remember { mutableStateOf(selectTabIndex) } // Chọn tab "Đang giao" hoặc "Đã giao"

    Column(modifier = modifier) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .width(187.5.dp)
                        .height(3.dp)
                        .background(color = Color(0xFF5D4037))
                        .offset(y = 13.dp)
                )
            },
            modifier = Modifier
                .background(color = Color(0xFFFEFEFE))
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 }
            ) {
                Text(
                    text = "Đang giao",
                    style = MaterialTheme.typography.titleSmall
                )
            }

            Tab(
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Đã giao",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
        Box(
            modifier = Modifier
                //.background(Color.LightGray)
        ) {
            val shippingOrders = allOrders.filter { it.status == OrderStatus.SHIPPING || it.status == OrderStatus.PREPARE}
            val shippedOrders = allOrders.filter { it.status == OrderStatus.DELIVERED }

            // Hiển thị nội dung của mỗi tab ở đây
            if (selectedTabIndex == 0) {
                LazyColumn {
                    items(shippingOrders) { order ->
                        OrderItem(
                            order = order,
                            showTotalPrice = true,
                            onOrderClick = {
                                val orderId = order.id
                                navController?.navigate(Screen.FollowShipping.createRoute(orderId))
                            }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(100.dp))
                    }
                }
            } else {
                LazyColumn {
                    items(shippedOrders) { order ->
                        OrderItem(
                            order = order,
                            showTotalPrice = false,
                            onOrderClick = {
                                navController?.navigate("order/${order.id}")
                            }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(100.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun OrderItem(
    modifier: Modifier = Modifier,
    order: Order,
    showTotalPrice: Boolean = true,
    onOrderClick: () -> Unit = { }
) {
    val products = order.products

    Column (
        modifier = modifier.clickable { onOrderClick() }
    ) {
        products.forEach { product ->
            Spacer(modifier = Modifier.height(8.dp))
            CheckoutItem(product = product)
            // Đánh giá
            if (showTotalPrice == false) {
                RatingStar(
                    initialRating = product.star.toInt(), // Đặt giá trị đánh giá ban đầu nếu có
                    onRatingChanged = { newRating ->
                        // Xử lý sự kiện thay đổi đánh giá
                        // TODO
                    }
                )
            }
        }
        // tiền
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(end = 12.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            if (showTotalPrice) {
                Text(
                    text = "Thành tiền: ${(order.total).toInt()}đ",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFFEE2828),
                    ),
                    textAlign = TextAlign.End,
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color(0xFFEE2828),
                )
            }
        }
    }
}

@Composable
fun RatingStar(
    maxStars: Int = 5,
    initialRating: Int = 0,
    onRatingChanged: (Int) -> Unit
) {
    var rating by remember { mutableStateOf(initialRating) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        for (i in 1..maxStars) {
            IconButton(
                onClick = {
                    rating = i
                    onRatingChanged(rating)
                },
                modifier = Modifier
                    .width(36.dp)
                    .height(36.dp)// Kích thước của mỗi sao
            ) {
                // Sử dụng điều kiện để chọn icon cho sao (filled hoặc unfilled)
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = if (i <= rating) Color.Yellow else Color.Gray // Tô màu sao filled hoặc unfilled
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabPreview() {
    PetShopTheme {
        ShipmentStateScreen(
            orderViewModel = OrderViewModel(),
        )
    }
}
