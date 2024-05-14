package com.example.petshop.ui.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshop.R
import com.example.petshop.model.Product
import com.example.petshop.ui.PetShopBottomNavigationBar
import com.example.petshop.ui.PetShopTopAppBar

@Composable
fun HomeScreen() {
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

    var selectedTabIndex by remember { mutableStateOf(0) } // Chọn tab "Đang giao" hoặc "Đã giao"
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            PetShopTopAppBar(
                onAction1Clicked = { Log.d("HomeScreen", "Action 1 clicked") },
                onAction2Clicked = { Log.d("HomeScreen", "Action 2 clicked") },
                onAction3Clicked = { Log.d("HomeScreen", "Action 3 clicked") },
                onSearchIconClicked = { Log.d("HomeScreen", "Search icon clicked") },
                onSearchTextChanged = {text -> searchText = text },
                searchText = searchText,

            )
        },
        bottomBar = { PetShopBottomNavigationBar() }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            HorizontalBanner(bannerItems = bannerItems)
            Box {
                ProductTabs(
                    selectedTabIndex,
                    firstTabProduct = products,
                    secondTabProduct = products,
                    //thirdTabProduct = products,
                ) { tab ->
                    selectedTabIndex = tab
                }
            }

        }
    }
}

@Composable
fun ProductWithStar(
    modifier: Modifier = Modifier,
    product: Product,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .width(69.dp)
                .height(69.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.avt),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(69.dp)
                    .height(69.dp)
                    .shadow(
                        elevation = 2.2138051986694336.dp,
                        spotColor = Color(0x05000000),
                        ambientColor = Color(0x05000000)
                    )
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(69.dp)
                    .padding(top = 8.dp) // spacing between image and rating
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        2.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(43.dp)
                        .height(20.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(start = 4.dp, top = 1.dp, end = 4.dp, bottom = 1.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "image description",
                        contentScale = ContentScale.None
                    )
                    Text(
                        text = product.star.toString(),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }

        Column(
            modifier = Modifier.width(200.dp),
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                // định dạng không có dấu chấm
                text = product.price.toString().replace(".0", "") + " đ",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.End,
            )
            Text(
                text = product.oldPrice.toString().replace(".0", "") + " đ",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.End,
                textDecoration = TextDecoration.LineThrough
            )
        }
    }
}

@Composable
fun ProductTabs(
    selectedTabIndex: Int,
    firstTabProduct: List<Product> = listOf(),
    secondTabProduct: List<Product> = listOf(),
    thirdTabProduct: List<Product> = listOf(),
    onTabSelected: (Int) -> Unit,
) {
    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        //.width(187.5.dp)
                        .height(3.dp)
                        .background(color = Color(0xFF5D373F))
                        .offset(y = 13.dp)
                )
            },
            modifier = Modifier
                .background(color = Color(0xFFFFFFFF))
                //.height(56.dp)
        ) {
            val tabs = listOf("Thức ăn", "Dụng cụ", "Thời trang")
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { onTabSelected(index) },
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
        Box(
            modifier = Modifier.background(Color.White)
        ) {
            // Display tab content
            when (selectedTabIndex) {
                0 -> TabContent(products = firstTabProduct)
                1 -> TabContent(products = secondTabProduct)
                2 -> TabContent(products = thirdTabProduct)
            }
        }
    }
}

@Composable
fun TabContent(products: List<Product>) {
    LazyColumn {
        items(products.size) { index ->
            ProductWithStar(product = products[index])
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalBanner(bannerItems: List<Painter>) {
    val pagerState = rememberPagerState(pageCount = { bannerItems.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val bannerItem = bannerItems[it]
        // Hiển thị nội dung của mỗi mục trong banner ở đây
        Image(
            painter = bannerItem,
            contentDescription = null,
            contentScale = ContentScale.FillBounds, // Lấp đầy hình ảnh trong kích thước đã cho
            modifier = Modifier.fillMaxSize() // Lấp đầy kích thước của Parent
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

