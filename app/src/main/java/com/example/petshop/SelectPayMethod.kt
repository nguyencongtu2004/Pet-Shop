package com.example.petshop

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun SelectPayMethod(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = { PetShopAppBar(title = "Phương thức thanh toán") }
    ) {
        Box(
            modifier = Modifier.padding(it),
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                var isSelect1 by remember { mutableStateOf(false) }
                var isSelect2 by remember { mutableStateOf(false) }

                PayMethod(
                    imageId = R.drawable.cash,
                    title = "Thanh toán khi nhận hàng",
                    description = "Miễn phí thu hộ",
                    isSelected = isSelect1,
                    onClick = {
                        isSelect1 = !isSelect1
                        isSelect2 = false
                    })
                PayMethod(
                    imageId = R.drawable.transfer,
                    title = "Chuyển khoản ngân hàng",
                    description = "(Tự động kiểm tra)",
                    isSelected = isSelect2,
                    onClick = {
                        isSelect2 = !isSelect2
                        isSelect1 = false
                    })
                Divider(color = Color(0xFFD9D9D9))
                AddPayMethod(onClick = { println("Thêm thẻ hehe") })
            }

        }
    }
}

@Composable
fun PayMethod(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    @DrawableRes imageId: Int,
    title: String,
    description: String,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(48.dp),
            contentScale = ContentScale.Fit
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            )
    }
}

@Composable
fun AddPayMethod(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = R.drawable.add_pay_method),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(48.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Thẻ tín dụng",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Visa, Mastercard, AMEX, và JCB",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF46AE7C))
        ) {
            Text(
                text = "Thêm",
                style = MaterialTheme.typography.titleMedium
            )

        }
    }
}

@Composable
fun PetShopAppBar(
    modifier: Modifier = Modifier,
    title: String
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 14.dp, end = 16.dp, bottom = 14.dp)
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 20.sp
            ),
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        )
    }
}

@Preview
@Composable
fun SelectPayMethodPreview() {
    PetShopTheme {
        SelectPayMethod()
    }
    //PayMethod()
    //AddPayMethod()
}