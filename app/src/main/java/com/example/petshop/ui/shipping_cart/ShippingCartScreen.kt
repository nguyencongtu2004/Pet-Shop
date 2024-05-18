package com.example.petshop.ui.shipping_cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.AlertDialog
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
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshop.view_model.CartViewModel
import com.example.petshop.model.FoodProduct
import com.example.petshop.model.Product
import com.example.petshop.model.Screen
import com.example.petshop.ui.CheckoutBottomBar
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    cartViewModel: CartViewModel,
) {
    val selectedProducts by cartViewModel.selectedProducts.collectAsState()
    val productsInCart by cartViewModel.productsInCart.collectAsState()
    val totalAmount by cartViewModel.totalAmount.collectAsState()

    // Thêm biến trạng thái để kiểm tra xem reset đã được thực hiện chưa
    var isInitialized by remember { mutableStateOf(false) }

    // Reset các sản phẩm đã chọn nếu chưa được thực hiện
    if (!isInitialized) {
        cartViewModel.resetSelectedProducts()
        isInitialized = true
    }

    Scaffold(
        bottomBar = {
            if (selectedProducts.isNotEmpty())
                CheckoutBottomBar(
                    total = totalAmount,
                    onBuyClicked = {
                        navController?.navigate(Screen.CheckoutScreen.route)
                    }
                )
        }
    ) {
        LazyColumn(
            modifier = modifier.padding(it),
        ) {
            items(productsInCart) { product ->
                BoughtItemCart(
                    product = product,
                    onQuantityChange = { isChecked, newQuantity ->
                        if (isChecked) {
                            if (!selectedProducts.contains(product)) {
                                cartViewModel.addProductToSelected(product)
                            }
                            product.quantity = newQuantity
                        } else {
                            cartViewModel.removeProductFromSelected(product)
                        }
                        cartViewModel.updateTotalAmount()
                    },
                    onDeleteClick = {
                        cartViewModel.removeProductFromCart(product)
                        cartViewModel.updateTotalAmount()
                    }
                )
                Divider()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoughtItemCart(
    modifier: Modifier = Modifier,
    product: Product = FoodProduct(),
    onQuantityChange: (Boolean, Int) -> Unit,
    onDeleteClick: () -> Unit = {},
) {
    var quantity by remember { mutableStateOf(product.quantity) }
    var checkedState by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    // Hiện dialog xác nhận xóa sản phẩm khỏi giỏ hàng
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(
                text = "Xác nhận xóa",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            ) },
            text = { Text(
                text = "Bạn có chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng?",
                style = MaterialTheme.typography.bodyMedium,
            ) },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        onDeleteClick()
                    }
                ) {
                    Text("Xóa")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Hủy")
                }
            }
        )
    }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp, bottom = 6.dp)
            .clickable {
                checkedState = !checkedState
                onQuantityChange(checkedState, quantity)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp, top = 5.dp, end = 10.dp)
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
                    painter = painterResource(id = product.image),
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
                        //.width(160.dp)
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
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { showDialog = true }) {
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
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 18.sp
                        ),
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
            cartViewModel = CartViewModel(),
        )
    }
}
