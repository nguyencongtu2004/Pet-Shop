package com.example.petshop.ui.shipment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.petshop.R
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Product
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun ShipmentStateScreen(
    modifier: Modifier = Modifier,
    shippingProducts: List<Product> = listOf(),
    shippedProducts: List<Product> = listOf(),
    selectTabIndex: Int = 0,
) {
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
            // Hiển thị nội dung của mỗi tab ở đây
            if (selectedTabIndex == 0) {
                LazyColumn {
                    items(shippingProducts.size) { index ->
                        OrderItem(product = shippingProducts[index], showTotalPrice = true)
                    }
                }
            } else {
                LazyColumn {
                    items(shippedProducts.size) { index ->
                        OrderItem(product = shippedProducts[index], showTotalPrice = false)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderItem(
    modifier: Modifier = Modifier,
    product: Product = FoodProduct(),
    showTotalPrice: Boolean = true,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp, bottom = 6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 13.dp)
        ) {
            Image(
                painter = product.image ?: painterResource(id = R.drawable.avt),
                contentDescription = null,
                modifier = Modifier
                    .shadow(
                        elevation = 2.2138051986694336.dp,
                        spotColor = Color(0x05000000),
                        ambientColor = Color(0x05000000)
                    )
                    .shadow(
                        elevation = 5.32008171081543.dp,
                        spotColor = Color(0x07000000),
                        ambientColor = Color(0x07000000)
                    )
                    .shadow(
                        elevation = 10.017241477966309.dp,
                        spotColor = Color(0x09000000),
                        ambientColor = Color(0x09000000)
                    )
                    .shadow(
                        elevation = 17.869047164916992.dp,
                        spotColor = Color(0x0B000000),
                        ambientColor = Color(0x0B000000)
                    )
                    .shadow(
                        elevation = 33.422088623046875.dp,
                        spotColor = Color(0x0D000000),
                        ambientColor = Color(0x0D000000)
                    )
                    .width(69.dp)
                    .height(69.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(9.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    item {
                        if (product is FoodProduct)
                            FilterChip(
                                label = {
                                    Text(
                                        text = product.flavor,
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                },
                                onClick = { /*TODO*/ },
                                selected = true,
                                colors = FilterChipDefaults.filterChipColors(
                                    labelColor = Color(0xFF000000),
                                    selectedLabelColor = Color.White,
                                    selectedContainerColor = Color(0xFF5D4037),
                                ),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.height(28.dp)
                            )
                    }
                    item {
                        if (product is FoodProduct)
                            FilterChip(
                                label = {
                                    Text(
                                        text = "${product.weight}kg",
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                },
                                onClick = { /*TODO*/ },
                                selected = true,
                                colors = FilterChipDefaults.filterChipColors(
                                    labelColor = Color(0xFF000000),
                                    selectedLabelColor = Color.White,
                                    selectedContainerColor = Color(0xFF5D4037),
                                ),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.height(28.dp)
                            )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "${product.price.toInt()}đ",
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "x${product.quantity}",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
            ) {
                Spacer(modifier = Modifier.weight(1f))
                if (showTotalPrice) {
                    Text(
                        text = "Thành tiền: ${(product.price * product.quantity).toInt()}đ",
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
                } else {
                    RatingStar(
                        initialRating = product.star.toInt(), // Đặt giá trị đánh giá ban đầu nếu có
                        onRatingChanged = { newRating ->
                            // Xử lý sự kiện thay đổi đánh giá
                            // TODO
                        }
                    )
                }
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
            shippingProducts = listOf(
                FoodProduct(
                    name = "Thức ăn hạt mềm Zenith",
                    description = "Nổi tiếng với đồ ăn cho chó con được yêu thích",
                    price = 90000.0,
                    quantity = 1,
                    image = painterResource(id = R.drawable.avt),
                    flavor = "Cá hồi",
                    weight = 0.5
                )
            ),
            shippedProducts = listOf(
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
        )
    }
}
