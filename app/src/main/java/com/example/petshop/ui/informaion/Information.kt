package com.example.petshop.ui.informaion

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.R
import com.example.petshop.ui.PetShopAppBar


@Composable
fun Information() {
    Scaffold(
        topBar = { PetShopAppBar(title = "Thông tin tài khoản") }
    ) {
        Column (
            modifier = Modifier.padding(it)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(82.dp)
                        .height(82.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = "Nguyễn Công Tú",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 25.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF555555),
                        )
                    )
                    Text(
                        text = "Khách hàng thân thiết",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF48854B),

                            )
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Chỉnh sửa",
                            style = MaterialTheme.typography.labelMedium
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
        }
    }
}

@Preview
@Composable
fun InformationPreview() {
    Information()
}