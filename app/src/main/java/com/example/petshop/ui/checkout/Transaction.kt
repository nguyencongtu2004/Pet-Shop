package com.example.petshop.ui.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.R
import com.example.petshop.ui.PetShopAppBar
import com.example.petshop.ui.login_register.Button
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun Transaction(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = { PetShopAppBar(title = "Chi tiết đơn hàng") /* Được định nghĩa trong SelectPayMethod.kt */ },
        bottomBar = {
            ActionBottomBar(modifier = Modifier
                .padding(16.dp)
            )
        }
    ) {
        // Lấy kích thước màn hình
        val configuration = LocalConfiguration.current
        val screenSize = with(LocalDensity.current) {
            Pair(configuration.screenWidthDp.dp, configuration.screenHeightDp.dp)
        }
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Column(
                        modifier = Modifier.padding(top = 45.dp)
                    ) {
                        Row {
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFEFEBE9),
                                        shape = RoundedCornerShape(size = 16.dp)
                                    )
                                    .padding(24.dp)
                                    .weight(1f)
                            ) {
                                Spacer(modifier = Modifier.height(4.dp))
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    Text(
                                        text = "Cảm ơn bạn!",
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                    Text(
                                        text = "Thanh toán thành công!",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .padding(
                                            start = 8.dp,
                                            top = 5.dp,
                                            end = 8.dp,
                                            bottom = 5.dp
                                        )
                                ) {
                                    ItemBold(title = "Mã đơn hàng", detail = "D123456789ABC")
                                    ItemBold(title = "Ngày", detail = "10 July’22")
                                    ItemBold(title = "Thời gian", detail = "04:13 PM")

                                }
                                Divider()
                                Column(
                                    horizontalAlignment = Alignment.Start,
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                ) {
                                    Text(
                                        text = "Vật phẩm:",
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    ItemBold(title = "Thức ăn hạt mềm Zenith", detail = "x1")
                                    Text(
                                        text = "Phân loại: Cá hồi - 0.5kg",
                                        style = MaterialTheme.typography.bodySmall,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Column(
                                    horizontalAlignment = Alignment.Start,
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                ) {
                                    Text(
                                        text = "Chi tiết thanh toán:",
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    ItemMedium(title = "Tổng tiền hàng:", detail = "45.000 đ")
                                    ItemMedium(title = "Phí vận chuyển:", detail = "12.000 đ")
                                    ItemMedium(title = "Voucher:", detail = "- 0 đ")
                                    ItemBold(title = "Tổng cộng:", detail = "57.000 đ")
                                }
                                Divider()
                                ItemMedium(
                                    title = "Phương thức thanh toán:",
                                    detail = "Khi nhận hàng",
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                )
                                ItemMedium(
                                    title = "Thời gian dự kiến:",
                                    detail = "1 - 2 ngày",
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.pay_done),
                        contentDescription = null,
                        modifier = Modifier
                            .height(75.dp)
                            .width(75.dp) // Đặt kích thước hình ảnh
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun ItemBold(
    modifier: Modifier = Modifier,
    title: String,
    detail: String = "",
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 14.sp
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = detail,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ItemMedium(
    modifier: Modifier = Modifier,
    title: String,
    detail: String = "",
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = detail,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Right
        )
    }
}

@Composable
fun ActionBottomBar(
    modifier: Modifier = Modifier,
    onGoHome: () -> Unit = {}
) {
        Row(
            modifier = modifier
        ) {
            Button(
                onClick = { /*TODO*/ },
                title = "Trở về trang chủ",
                isDisable = false,
                color = Color(0xFFA1887F),
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = { /*TODO*/ },
                title = "Theo dõi đơn hàng",
                isDisable = false,
                color = Color(0xFF46AE7C),
                modifier = Modifier
                    .weight(1f)
            )
        }
}

@Preview
@Composable
fun TransactionPreview() {
    PetShopTheme {
        Transaction()
        //Action()
    }
}