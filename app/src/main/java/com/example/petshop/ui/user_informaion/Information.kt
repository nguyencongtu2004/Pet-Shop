package com.example.petshop.ui.user_informaion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily


import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.R
import com.example.petshop.ui.PetShopAppBar


@Composable
fun Information() {
    val imgSize = 30.dp
    Scaffold(
        topBar = { PetShopAppBar(title = "Thông tin tài khoản") }
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(it)
                .background(color = Color.LightGray)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(color = Color.White)
            ) {
                Box (
                    modifier = Modifier
                        .width(82.dp)
                        .height(82.dp)
                        .offset(x = 10.dp, y = 0.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(82.dp)
                            .height(82.dp)
                            .clip(CircleShape)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = "Võ Hoàng Tuấn",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 25.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF555555),
                        ),
                        modifier = Modifier.padding(vertical = 5.dp)
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
                        modifier = Modifier
                            .width(100.dp)
                            .height(25.dp)
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
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Box (
                    Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Đơn hàng",
                        style = TextStyle(
                            fontSize = 28.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    )
                }

                Box (
                    Modifier.padding(horizontal = 10.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(29.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(
                                    color = Color(0xFFE5AE6D),
                                    shape = RoundedCornerShape(size = 30.dp)
                                )
                                .width(160.dp)
                                .height(90.dp)
                        ) {
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.padding(all = 0.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.fi_truck),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(30.dp)
                                        .height(30.dp)
                                )
                            }
                            Text(
                                text = "Đang giao",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF222222),
                                    textAlign = TextAlign.Center,
                                ),
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                        }

                        Column (
                            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(
                                    color = Color(0xFF76EE89),
                                    shape = RoundedCornerShape(size = 30.dp)
                                )
                                .width(160.dp)
                                .height(90.dp)
                        ) {
                            IconButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.padding(all = 0.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.fi_package),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(30.dp)
                                        .height(30.dp)
                                )
                            }
                            Text(
                                text = "Đã giao",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF222222),
                                    textAlign = TextAlign.Center,
                                ),
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                        }
                    }
                }
            }

            Column (
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(imgSize)
                            .height(imgSize)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "Sửa địa chỉ nhận hàng",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fav),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(imgSize)
                            .height(imgSize)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "Sản phẩm yêu thích",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(imgSize)
                            .height(imgSize)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "Giới thiệu cho bạn bè",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shop_infor),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(imgSize)
                            .height(imgSize)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "Thông tin cửa hàng",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.infor),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(imgSize)
                            .height(imgSize)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "Thông tin ứng dụng",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.log_out),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        colorFilter = ColorFilter.tint(Color.Red),
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .width(imgSize)
                            .height(imgSize)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "Đăng xuất",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                        )
                    )
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