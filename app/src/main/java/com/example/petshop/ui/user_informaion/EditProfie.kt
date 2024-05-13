package com.example.petshop.ui.user_informaion

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.R
import com.example.petshop.ui.PetShopAppBar
import com.example.petshop.ui.login_register.Button

@Composable
fun EditProfie() {
    val iconSize = 30.dp
    Scaffold (
        topBar = { PetShopAppBar(title = "Sửa hồ sơ") }
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(it)
                .background(color = Color.LightGray)
                .fillMaxWidth()
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth()
                    .height(350.dp)
                    .background(color = Color.White)
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(20.dp)
                ) {
                    Box (
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                            .offset(x = 0.dp, y = 0.dp)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.avatar),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(150.dp)
                                .height(150.dp)
                                .clip(CircleShape)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .width(74.dp)
                            .height(27.dp)
                    ) {
                        Text(
                            text = "Sửa",
                            style = TextStyle(
                                fontSize = 25.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                            )
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(all = 0.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.edit_profie),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(all = 0.dp)
                                    .width(iconSize)
                                    .height(iconSize)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Tên",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            ),
                        modifier = Modifier.padding(10.dp)
                        )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Võ Hoàng Tuấn",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(all = 0.dp)
                        ) {
                            Image(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(all = 0.dp)
                                    .width(iconSize)
                                    .height(iconSize)
                            )
                        }
                    }
                }
            }
            Column (
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Giới tính",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.padding(10.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Nam",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(all = 0.dp)
                        ) {
                            Image(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(all = 0.dp)
                                    .width(iconSize)
                                    .height(iconSize)
                            )
                        }
                    }
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Ngày sinh",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.padding(10.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "1/1/1111",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(all = 0.dp)
                        ) {
                            Image(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(all = 0.dp)
                                    .width(iconSize)
                                    .height(iconSize)
                            )
                        }
                    }
                }
            }
            Column (
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Số điện thoại",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.padding(10.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "0123456789",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(all = 0.dp)
                        ) {
                            Image(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(all = 0.dp)
                                    .width(iconSize)
                                    .height(iconSize)
                            )
                        }
                    }
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Email",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.padding(10.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "a@b.com",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(all = 0.dp)
                        ) {
                            Image(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(all = 0.dp)
                                    .width(iconSize)
                                    .height(iconSize)
                            )
                        }
                    }
                }
            }
            Column (
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        text = "Địa chỉ",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.padding(10.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(3.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Box (
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(
                                text = "fakjfkoạgkạokaodkoapdo",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color.Gray,
                                    textAlign = TextAlign.Center,
                                ),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.padding(all = 0.dp)
                        ) {
                            Image(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(all = 0.dp)
                                    .width(iconSize)
                                    .height(iconSize)
                            )
                        }
                    }
                }
            }
            Column (
                modifier = Modifier
                    .background(Color.White)
                    .weight(1f)
            ) {
                Spacer(modifier = Modifier
                    .background(Color.White)
                    .weight(1f)
                )
                Row (
                    horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 30.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 10.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                color = Color.Green,
                                shape = RoundedCornerShape(size = 30.dp)
                            )
                            .width(100.dp)
                            .height(40.dp)
                    )   {
                        Text(
                            text = "Xong",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(500),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun EditProfiePreview()
{
    EditProfie()
}
