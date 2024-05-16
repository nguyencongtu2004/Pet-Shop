package com.example.petshop.ui.checkout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshop.model.User

@Composable
fun Information(
    modifier: Modifier = Modifier,
    user: User = User(),
    onEditAddressClick: () -> Unit = { /*TODO*/ },
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = "Thông tin người nhận",
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = user.name,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight(300),
                color = Color(0xFF3C3C3C),
            ),
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = user.phone,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight(300),
                color = Color(0xFF3C3C3C),
            ),
        )
        Spacer(modifier = Modifier.height(4.dp))
        Divider()
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Địa chỉ",
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = user.name,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight(300),
                color = Color(0xFF3C3C3C),
            ),
        )




        Row(
            modifier = Modifier
                .width(100.dp)
                .height(25.dp)
                .clickable { onEditAddressClick() }
                .align(Alignment.End)
        ) {
            Text(
                text = "Chỉnh sửa",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(vertical = 5.dp)
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(all = 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.padding(all = 0.dp)
                )
            }
        }
    }
}

@Composable
fun Delivery(
    modifier: Modifier = Modifier,
    onPaymentClick: () -> Unit = {},
    onVoucherClick: () -> Unit = {}
) {
    Column(
        //verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
    ) {
        Divider(
            modifier = Modifier
                .width(375.dp)
                .height(4.dp)
                .background(color = Color(0xFFEFEBE9))
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Phương thức giao hàng",
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "*Chúng tôi mở cửa từ 8:00 - 18:00",
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight(300),
                color = Color(0xFF555555),
            ),
        )
        Spacer(modifier = Modifier.height(4.dp))
        DeliveryOption(
            title = "Hỏa tốc",
            description = "Khoảng 30 phút"
        )
        Divider()
        DeliveryOption(
            title = "Thường",
            description = "Khoảng 1 đến 2 ngày"
        )

        Divider()

        Spacer(modifier = Modifier.height(4.dp))
        PaymentOption(
            title = "Phương thức thanh toán",
            description = "Thanh toán trực tiếp",
            onClick = onPaymentClick
        )
        Divider()
        PaymentOption(
            title = "Voucher",
            description = "Không có voucher nào được thêm",
            onClick = onVoucherClick
        )

        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .width(375.dp)
                .height(4.dp)
                .background(color = Color(0xFFEFEBE9))
        )
    }
}

@Composable
fun DeliveryOption(
    title: String,
    description: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /*TODO*/ }
            .padding(vertical = 8.dp)
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(500),
                    color = Color(0xFF3C3C3C),
                ),
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight(300),
                    color = Color(0xFF555555),
                ),
            )
        }
        RadioButton(
            selected = false,
            onClick = { /*TODO*/ }
        )
    }
}

@Composable
fun PaymentOption(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp)
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.height(4.dp))
            if (description.isNotEmpty()) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(300),
                        color = Color(0xFF555555),
                    ),
                )
            }
        }
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .padding(all = 0.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .padding(all = 0.dp)

            )
        }
    }
}




@Composable
fun PaymentDetail(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = "Chi tiết thanh toán",
            style = MaterialTheme.typography.titleMedium,
        )

        PaymentDetailRow(
            label = "Tổng tiền hàng",
            value = "45.000 đ",
            description = "(1 sản phẩm)",
            isBold = true,
        )

        PaymentDetailRow(
            label = "Phí vận chuyển",
            value = "12.000 đ",
            isBold = true,
        )

        PaymentDetailRow(
            label = "Tổng cộng",
            value = "57.000 đ",
            isBold = true,
        )
    }
}

@Composable
fun PaymentDetailRow(
    label: String,
    value: String,
    description: String = "",
    isBold: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = if (isBold) FontWeight(500) else FontWeight(400),
                    color = Color(0xFF3C3C3C),
                ),
            )
            if (description.isNotEmpty()) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight(300),
                        color = Color(0xFF555555),
                    ),
                )
            }
        }
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = if (isBold) FontWeight(500) else FontWeight(400),
                color = Color(0xFF3C3C3C),
                textAlign = TextAlign.Right,
            ),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun InformationPreview() {
    Information()

}

@Preview(showBackground = true)
@Composable
fun DeliveryPreview() {
    Delivery()
}

@Preview(showBackground = true)
@Composable
fun PaymentDetailPreview() {
    PaymentDetail()
}