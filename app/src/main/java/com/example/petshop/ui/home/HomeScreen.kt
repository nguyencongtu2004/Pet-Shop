package com.example.petshop.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petshop.R
import com.example.petshop.model.ClothesProduct
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Product
import com.example.petshop.model.ToyProduct
import com.example.petshop.view_model.BannerViewModel
import com.example.petshop.view_model.ProductViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.max

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController? = null,
    productViewModel: ProductViewModel,
    bannerViewModel: BannerViewModel,
    onProductClick: (String) -> Unit = {},
) {
    val allProducts by productViewModel.allProducts.collectAsState()
    val firstTabProduct = allProducts.filterIsInstance<FoodProduct>()
    val secondTabProduct = allProducts.filterIsInstance<ToyProduct>()
    val thirdTabProduct = allProducts.filterIsInstance<ClothesProduct>()
    val bannerItems = bannerViewModel.allBanners

    // Chọn tab mặc định là tab thứ nhất
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val lazyListState = rememberLazyListState()

    val selectedProducts = when (selectedTabIndex) {
        0 -> firstTabProduct
        1 -> secondTabProduct
        else -> thirdTabProduct
    }

    val bannerHeight = 160.dp

    LazyColumn(
        state = lazyListState
    ) {
        item {
            HorizontalBanner(bannerItems = bannerItems)
        }
        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ProductTabs(
                    selectedTabIndex = selectedTabIndex,
                    onTabSelected = { tab ->
                        selectedTabIndex = tab
                    }
                )
            }
        }
        items(selectedProducts) { product ->
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
            ProductWithStar(
                product = product,
                onProductClick = onProductClick
            )
        }
    }
}

@Composable
fun ProductTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = MaterialTheme.colorScheme.onBackground,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .height(3.dp)
                    .background(color = Color(0xFF5D373F))
                    .offset(y = 13.dp)
            )
        },
        modifier = Modifier
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
}

@Composable
fun ProductWithStar(
    modifier: Modifier = Modifier,
    product: Product,
    onProductClick: (String) -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(8.dp)
            .clickable { onProductClick(product.id) }
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
            modifier = Modifier
                .weight(1f),
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
            modifier = Modifier
                .width(100.dp)
                .padding(end = 8.dp),
            horizontalAlignment = Alignment.End,
        ) {
            Text(
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
fun HorizontalBanner(bannerItems: List<Int>) {
    val pagerState = rememberPagerState(pageCount = { bannerItems.size })
    var isAutoScrollEnabled by remember { mutableStateOf(true) }
    var lastInteractionTime by remember { mutableStateOf(System.currentTimeMillis()) }

    // Tạo hiệu ứng tự động cuộn banner sau mỗi 3 giây
    LaunchedEffect(pagerState) {
        while (true) {
            yield() // Nhường cho các thành phần khác để tránh khối lệnh bị treo
            delay(5000)
            if (isAutoScrollEnabled) {
                val nextPage = (pagerState.currentPage + 1) % bannerItems.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    // Theo dõi sự thay đổi của trang hiện tại để kích hoạt lại tự động cuộn
    LaunchedEffect(pagerState.currentPage) {
        isAutoScrollEnabled = false
        lastInteractionTime = System.currentTimeMillis()
        delay(5000)
        if (System.currentTimeMillis() - lastInteractionTime >= 5000) {
            isAutoScrollEnabled = true
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
    ) { page ->
        val bannerItem = bannerItems[page]
        Image(
            painter = painterResource(id = bannerItem),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        productViewModel = ProductViewModel(),
        bannerViewModel = BannerViewModel(),
    )
}
