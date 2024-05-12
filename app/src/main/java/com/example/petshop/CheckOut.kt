package com.example.petshop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.model.Product
import com.example.petshop.ui.theme.BoughtItem
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun CheckOut(){
    Scaffold(
        topBar = { PetShopAppBar(title = "Thanh toán") },
        bottomBar = { EndBar() }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            var product: Product = Product("Thức an", "Cho chó", 45000.0, 2)
            BoughtItem(p = product)
            LazyColumn {
                item {
                    Information()
                }

                item {
                    Divider(
                        modifier = Modifier
                            .height(4.dp)
                            .background(color = Color(0xFFEFEBE9))
                    )
                }

                item {
                    Delivery()
                }
            }
        }
    }
}


@Composable
fun EndBar() {
    BottomAppBar(
        modifier = Modifier
            .height(66.dp)
            .background(color = Color(0xFFFEFEFE))
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(9.dp))

            Column {
                Text(
                    text = "Tổng cộng",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF555555),
                        textAlign = TextAlign.Center,
                    )
                )

                Text(
                    text = "57.000 đ",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 26.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF3C3C3C),
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            androidx.compose.material3.Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(horizontal = 10.dp) // Add some horizontal padding to the button
                    .background(
                        color = Color(0xFFEE2828),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
            ) {
                Text(
                    text = "Thanh toán",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color.White, // Set text color to white
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PetShopTheme {
        CheckOut()
    }
}