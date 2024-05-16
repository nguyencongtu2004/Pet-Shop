package com.example.petshop.ui.checkout

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshop.R
import com.example.petshop.ui.theme.PetShopTheme


@Composable
fun SelectVoucher(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    onSearchVoucher: (String) -> Unit = {},
) {
    var isSelect1 by remember { mutableStateOf(false) }
    var isSelect2 by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (isSelect1 || isSelect2) {
                VoucherStatus(
                    onClick = { navController?.popBackStack()                    },
                    numVoucherSelected = if (isSelect1 || isSelect2) 1 else 0
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it),
        ) {
            var searchText by remember { mutableStateOf("") }
            SearchBox(
                value = searchText,
                onValueChange = { newText ->
                    searchText = newText
                },
                onDone = onSearchVoucher
            )
            LazyColumn(
                modifier = Modifier.padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Voucher list ở đây
                item {
                    Column (
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ){
                        Voucher(
                            imageId = R.drawable.voucher,
                            title = "Giảm 10% tối đa 20.000 đ",
                            description = "Không yêu cầu giá trị đơn hàng",
                            isSelected = isSelect1,
                            onClick = {
                                isSelect1 = !isSelect1
                                isSelect2 = false
                            }
                        )
                        Divider(color = Color(0xFFD9D9D9))
                        Voucher(
                            imageId = R.drawable.voucher,
                            title = "Giảm 15% tối đa 35.000 đ",
                            description = "Đơn tối thiểu 20.000 đ",
                            isSelected = isSelect2,
                            onClick = {
                                isSelect2 = !isSelect2
                                isSelect1 = false
                            }
                        )
                        Divider(color = Color(0xFFD9D9D9))
                        Voucher(
                            imageId = R.drawable.bca,
                            title = "Giảm 75.000 đ",
                            description = "Đơn tối thiểu 280.000 đ",
                            isDisable = true,
                            warning = "Mua thêm 223.000 đ để sử dụng voucher",
                            onClick = { }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Voucher(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    @DrawableRes imageId: Int,
    title: String,
    description: String,
    isDisable: Boolean = false,
    warning: String = "Không thể sử dụng",
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier =
        if (!isDisable)
            modifier
                .fillMaxWidth()
                .clickable { onClick() }
        else
            modifier.fillMaxWidth()
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
            if (isDisable)
                Text(
                    text = warning,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFFE33131)
                    )
                )
        }
        if (!isDisable)
            RadioButton(
                selected = isSelected,
                onClick = onClick,
            )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBox(
    value: String = "",
    onValueChange: (String) -> Unit,
    onDone: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current // để ẩn bàn phím
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = {
            Text(text = "Nhập mã giảm giá ở đây")
        },
        shape = RoundedCornerShape(16.dp),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                onDone(value)
                keyboardController?.hide()
            }
        ),

        )
}

@Composable
fun VoucherStatus(
    modifier: Modifier = Modifier,
    numVoucherSelected: Int = 0,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 20.dp)
    ) {
        Text(
            text = "Đã chọn $numVoucherSelected voucher",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 14.sp
            ),
            modifier = Modifier.weight(1f)
        )
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF46AE7C)),
            onClick = onClick
        ) {
            Text(
                text = "Sử dụng",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
fun SelectVoucherPreview() {
    PetShopTheme {
        SelectVoucher()
    }
}