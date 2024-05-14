package com.example.petshop.ui.shipment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.ui.PetShopAppBar
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun ShipmentStateScreen(){
    Scaffold(
        topBar = { PetShopAppBar(title = "Đơn hàng") }
    ) { paddingValues ->
        var selectedTabIndex by remember { mutableStateOf(0) } // Chọn tab "Đang giao" hoặc "Đã giao"

        // Apply padding to your content
        Box(modifier = Modifier.padding(paddingValues)) {
            ShippingAndShippedTab(selectedTabIndex) { tab ->
                selectedTabIndex = tab // Cập nhật trạng thái của tab khi người dùng chọn
            }
        }
    }
}

@Composable
fun ShippingAndShippedTab(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
) {
    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            //backgroundColor = Color.White,
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
                //.height(37.dp)
                .background(color = Color(0xFFFEFEFE))
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { onTabSelected(0) }
            ) {
                Text(
                    text = "Đang giao",
                    style = MaterialTheme.typography.titleSmall
                )
            }

            Tab(
                selected = selectedTabIndex == 1,
                onClick = { onTabSelected(1) },
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
                .background(Color.LightGray)
        ) {
            // Hiển thị nội dung của mỗi tab ở đây
            if (selectedTabIndex == 0) {
                LazyColumn {
                    item {
                        BoughtItemShipping()
                        BoughtItemShipping()
                        BoughtItemShipping()
                        BoughtItemShipping()
                        BoughtItemShipping()
                        BoughtItemShipping()
                    }
                }
            } else {
                LazyColumn {
                    item{
                        ShippedBoughtItem()
                        ShippedBoughtItem()
                        ShippedBoughtItem()
                        ShippedBoughtItem()
                        ShippedBoughtItem()
                        ShippedBoughtItem()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabPreview() {
    PetShopTheme {
        ShipmentStateScreen()
    }
}