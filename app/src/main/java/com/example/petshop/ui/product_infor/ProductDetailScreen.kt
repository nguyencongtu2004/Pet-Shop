package com.example.petshop.ui.product_infor

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshop.R
import com.example.petshop.model.ClothesProduct
import com.example.petshop.model.Flavor
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Product
import com.example.petshop.model.Screen
import com.example.petshop.model.Size
import com.example.petshop.model.ToyProduct
import com.example.petshop.model.Weight
import com.example.petshop.ui.DetailProductBottomBar
import com.example.petshop.ui.TopAppBarNoSearch
import com.example.petshop.view_model.ProductViewModel

@Composable
fun getScreenWidth(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}

@Composable
fun ProductDetail(
    productId: String,
    navController: NavController? = null,
    productViewModel: ProductViewModel,
    onBackClick: () -> Unit = {}
) {
    val allProducts by productViewModel.allProducts.collectAsState()
    val product = allProducts.find { it.id == productId }!!

    Scaffold(
        topBar = {
            TopAppBarNoSearch(
                title = product.name,
                isCartEnable = true,
                onCartClick = {
                    navController?.navigate(Screen.ShoppingCartScreen.route)
                },
                onBackClick = {
                    navController?.popBackStack()
                }
            )
        },
        bottomBar = {
            // TODO
            DetailProductBottomBar(
                onChatClicked = {},
                onAddToCartClicked = {},
                onBuyClicked = {},
            )
        }
    ) {
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(it)
        ) {
            ProductImageSection(product.image, scrollState)
            ProductInfoSection(
                product = product,
                onRateClick = { /*TODO*/ },
                onFavoriteClick = { /*TODO*/ },
            )
            ProductCustomizationSection(product)
            ProductDescriptionSection(product.detailDescription)
            Spacer(modifier = Modifier.height(500.dp))
        }
    }
}

@Composable
private fun ProductImageSection(
    imageResource: Int,
    scrollState: ScrollState,
) {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .graphicsLayer {
                alpha = 1f - (scrollState.value.toFloat() / scrollState.maxValue)
                translationY = 0.5f * scrollState.value
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .width(240.dp)
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun ProductInfoSection(
    product: Product,
    onRateClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
        //.align(Alignment.CenterHorizontally)
    ) {
        ProductInfoCard(
            product = product,
            onRateClick = onRateClick,
            onFavoriteClick = onFavoriteClick
        )
    }
}

@Composable
private fun ProductInfoCard(
    modifier: Modifier = Modifier,
    product: Product,
    onRateClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    val roundedSize = 10.dp
    Box(
        modifier = modifier
            .width((getScreenWidth() - 30).dp)
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = roundedSize))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            ProductTags(tags = product.tag)
            ProductTitleAndPrice(title = product.name, price = product.price)
            ProductDescription(description = product.description)
            ProductRatingAndFavorite(
                rating = product.star,
                onRateClick = onRateClick,
                onFavoriteClick = onFavoriteClick,
                isFavorite = false
            )
        }
    }
}

@Composable
private fun ProductTags(
    modifier: Modifier = Modifier,
    tags: List<String>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .width(350.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
            )
            .padding(10.dp)

    ) {
        items(tags) { tag ->
            ProductTag(
                text = tag, color = when (tag) {
                    "Thức ăn" -> Color(0xFF008000)
                    "Đồ chơi" -> Color(0xFF0000FF)
                    "Quần áo" -> Color(0xFFFFA500)
                    "Được yêu thích" -> Color(0xFFFF0000)
                    else -> Color(0xFF3C3C3C)
                }
            )
        }
    }
}

@Preview
@Composable
fun ProductTagsPreview() {
    ProductTag(text = "Thức ăn", color = Color(0xFF008000))
}

@Composable
private fun ProductTag(text: String, color: Color) {
    AssistChip(
        //enabled = false,
        onClick = { },
        label = {
            Text(
                text,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = color
                )
            )
        },
    )
}

@Composable
private fun ProductTitleAndPrice(
    modifier: Modifier = Modifier,
    title: String,
    price: Double
) {
    Row(
        //horizontalArrangement = Arrangement.spacedBy(11.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            //.fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color(0xFF5D4037)
            ),
            modifier = Modifier.width(250.dp)
        )
        Text(
            text = "${price.toInt()} đ",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp,
                color = Color(0xFF3C3C3C)
            ),
            textAlign = TextAlign.Right,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun ProductDescription(
    modifier: Modifier = Modifier,
    description: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFF555555)
            ),
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
        ProductQuantitySelector()// TODO: Add quantity selector
    }
}

@Composable
private fun ProductQuantitySelector(
    modifier: Modifier = Modifier,
    quantity: Int = 1,
    onMinusClick: () -> Unit = {},
    onPlusClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                shape = RoundedCornerShape(8.dp),
                width = 1.dp,
                color = Color(0xFFCACACA)
            )
    ) {
        IconButton(
            onClick = onMinusClick,
            modifier = Modifier
                .padding(1.dp)
                .width(30.dp)
                .height(30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.remove),
                contentDescription = null,
            )
        }
        Text(
            text = quantity.toString(),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 18.sp
            ),
            modifier = Modifier.width(36.dp),
            textAlign = TextAlign.Center
        )
        IconButton(
            onClick = onPlusClick,
            modifier = Modifier
                .padding(1.dp)
                .width(30.dp)
                .height(30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ProductRatingAndFavorite(
    modifier: Modifier = Modifier,
    rating: Double,
    onRateClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    isFavorite: Boolean = false,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            //.width(350.dp)
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onRateClick() }
        ) {
            Image(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(Color.Yellow)
            )
            Text(
                text = rating.toString(),
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color(0xFF5D4037)
                )
            )
            Text(
                text = "(??)",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color(0xFF5D4037)
                )
            )
            Text(
                text = "Đánh giá",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color(0xFF5D4037)
                )
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = onFavoriteClick) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.fav),
                    tint = Color.Red,
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .size(32.dp)
                )
                if (isFavorite)
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        tint = Color.Red,
                        contentDescription = "Favorite",
                        modifier = Modifier
                            .size(32.dp)
                    )

            }
        }
    }
}

@Composable
private fun ProductCustomizationSection(product: Product) {
    Box(
        modifier = Modifier
            .width((getScreenWidth() - 30).dp)
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = 10.dp))
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            ProductCustomizationTitle()
            when (product) {
                is FoodProduct -> ProductFoodCustomization()
                is ToyProduct -> ProductToyCustomization()
                is ClothesProduct -> ProductClothesCustomization()
                else -> {}
            }
        }
    }
}

@Composable
private fun ProductCustomizationTitle() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(11.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Text(
            text = "Chọn phân loại sản phẩm:",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color(0xFF3C3C3C)
            )
        )
    }
}


@Composable
private fun ProductFoodCustomization() {
    Column {
        ProductCustomizationOption(title = "Vị:", options = Flavor.entries.map { it.value })
        ProductCustomizationOption(title = "Kích cỡ:", options = Weight.entries.map { it.value })
    }
}

@Composable
private fun ProductClothesCustomization() {
    Column {
        ProductCustomizationOption(title = "Kích cỡ:", options = Size.entries.map { it.value })
    }
}

@Composable
private fun ProductToyCustomization() {
    Column {
        ProductCustomizationOption(title = "Kích cỡ:", options = Size.entries.map { it.value })
    }
}

@Composable
private fun ProductCustomizationOption(title: String, options: List<String>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))
            .padding(10.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3C3C3C)
            ),
            modifier = Modifier
                .width(80.dp)
                .padding(start = 10.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
            modifier = Modifier.weight(1f)
        ) {
            items(options) { option ->
                ProductCustomizationOptionItem(option)
            }
        }
    }
}

@Composable
private fun ProductCustomizationOptionItem(option: String) {
    AssistChip(
        onClick = { },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = Color(0xFF5D4037),
        ),
        label = {
            Text(
                option,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color.White
                )
            )
        },
    )
}

@Composable
private fun ProductDescriptionSection(description: String) {
    Box(
        modifier = Modifier
            .width((getScreenWidth() - 30).dp)
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = 10.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            ProductDescriptionTitle()
            ProductDescriptionText(description)
        }
    }
}

@Composable
private fun ProductDescriptionTitle() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFFFFF))
            .padding(10.dp)
    ) {
        Text(
            text = "Thông tin sản phẩm:",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color(0xFF3C3C3C)
            )
        )
    }
}

@Composable
private fun ProductDescriptionText(description: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp)
    ) {
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFF555555)
            )
        )
    }
}


@Preview
@Composable
fun ProductDetailPreview() {
    ProductDetail(
        productViewModel = ProductViewModel(),
        productId = "1"
    )
}
