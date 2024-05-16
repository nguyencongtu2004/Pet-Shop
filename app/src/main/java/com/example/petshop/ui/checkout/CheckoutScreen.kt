package com.example.petshop.ui.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshop.R
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Product
import com.example.petshop.ui.CheckoutEndBar
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun CheckoutScreen(
    modifier: Modifier = Modifier,
    products: List<Product> = listOf(),
) {
    Scaffold(
        modifier = modifier,
        bottomBar = { CheckoutEndBar(total = 200000.0)}
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(products) { product ->
                CheckoutItem(product = product)
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Information(
                    modifier.padding(10.dp)
                )
            }

            item {
                Divider(
                    modifier = Modifier
                        .height(4.dp)
                        .background(color = Color(0xFFEFEBE9))
                )
            }

            item {
                Delivery(modifier = Modifier.padding(10.dp))
            }

            item {
                PaymentDetail(
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutItem(
    modifier: Modifier = Modifier,
    product: Product = FoodProduct(
        name = "Thức ăn hạt mềm Zenith",
        description = "Nổi tiếng với đồ ăn cho chó con được yêu thích",
        price = 90000.0,
        oldPrice = 0.0,
        quantity = 1,
        star = 0.0,
        image = painterResource(id = R.drawable.avt),
        flavor = "Cá hồi",
        weight = 0.5
    ),
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
                modifier = Modifier.weight(1f)
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
            Column(
                //verticalArrangement = Arrangement.Center,
                //horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = product.price.toString().replace(".0", "") + "đ",
                    style = MaterialTheme.typography.titleMedium,

                    )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "x${product.quantity}",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            /*Text(
                text = "Phân loại:",
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.width(12.dp))*/
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
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
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckoutScreenPreview() {
    PetShopTheme {
        CheckoutScreen()
    }
}