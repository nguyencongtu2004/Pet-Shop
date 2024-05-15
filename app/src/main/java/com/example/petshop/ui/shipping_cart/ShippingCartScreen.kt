package com.example.petshop.ui.shipping_cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import com.example.petshop.ui.CheckoutBottomBar
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    products: List<Product> = emptyList(),
    onBuyClicked: () -> Unit = { }
) {
    var totalAmount by remember { mutableStateOf(0.0) }
    val selectedItems = remember { mutableStateListOf<Product>() }

    Scaffold(
        bottomBar = {
            if (selectedItems.isNotEmpty())
                CheckoutBottomBar(
                    total = totalAmount,
                    onBuyClicked = onBuyClicked
                )
        }
    ) {
        LazyColumn {
            items(products) { product ->
                BoughtItemCart(product = product, onQuantityChange = { isChecked, newQuantity ->
                    if (isChecked) {
                        if (!selectedItems.contains(product)) {
                            selectedItems.add(product)
                        }
                        product.quantity = newQuantity
                    } else {
                        selectedItems.remove(product)
                    }
                    totalAmount = selectedItems.sumOf { it.price * it.quantity }
                })
                Divider()
            }
        }
    }

    /*Text(
        text = "Total: ${totalAmount.toString().replace(".0", "")}đ",
        style = MaterialTheme.typography.titleSmall,
        textAlign = TextAlign.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )*/
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoughtItemCart(
    modifier: Modifier = Modifier,
    product: Product = FoodProduct(
        name = "Thức ăn hạt mềm Zenith",
        description = "Nổi tiếng với đồ ăn cho chó con được yêu thích",
        price = 90000.0,
        oldPrice = 0.0,
        quantity = 1,
        star = 0.0,
        image = painterResource(id = R.drawable.avt),
        type = "Cá hồi",
        weight = 0.5
    ),
    onQuantityChange: (Boolean, Int) -> Unit
) {
    var quantity by remember { mutableStateOf(product.quantity) }
    var checkedState by remember { mutableStateOf(false) }

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
            Checkbox(
                checked = checkedState,
                onCheckedChange = {
                    checkedState = it
                    onQuantityChange(checkedState, quantity)
                },
                modifier = Modifier
                    .padding(end = 14.dp)
                    .width(14.dp)
                    .height(14.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
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
            }
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
                        .width(160.dp)
                ) {
                    item {
                        if (product is FoodProduct)
                            FilterChip(
                                label = {
                                    Text(
                                        text = product.type,
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
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null
                        )
                    }
                    IconButton(
                        onClick = {
                            if (quantity > 1) quantity--
                            product.quantity = quantity
                            onQuantityChange(checkedState, quantity)
                        },
                        modifier = Modifier
                            .border(width = 1.dp, color = Color(0xFFCACACA))
                            .padding(1.dp)
                            .width(30.dp)
                            .height(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                        )
                    }
                    Text(
                        text = quantity.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.width(36.dp),
                        textAlign = TextAlign.Center
                    )
                    IconButton(
                        onClick = {
                            quantity++
                            product.quantity = quantity
                            onQuantityChange(checkedState, quantity)
                        },
                        modifier = Modifier
                            .border(width = 1.dp, color = Color(0xFFCACACA))
                            .padding(1.dp)
                            .width(30.dp)
                            .height(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = null
                        )
                    }
                }
            }
            Text(
                text = "${(product.price * quantity).toString().replace(".0", "")}đ",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoughtItemPreview() {
    PetShopTheme {
        ShoppingCartScreen(
            products = listOf(
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
            )
        )
    }
}
