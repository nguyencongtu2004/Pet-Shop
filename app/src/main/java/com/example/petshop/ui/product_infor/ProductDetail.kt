package com.example.petshop.ui.product_infor

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.example.petshop.R
import com.example.petshop.ui.PetShopAppBar
import com.example.petshop.ui.shipment.RatingStar
import kotlin.math.max
import kotlin.math.min

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProDuctDetail() {
    Scaffold(
        topBar = { PetShopAppBar(title = "") }
    ) {
        val scrollState = rememberScrollState()
        val roundedSize = 10.dp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .graphicsLayer {
                        alpha = 1f - (scrollState.value.toFloat() / scrollState.maxValue)
                        translationY = 0.5f * scrollState.value
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avt),
                    contentDescription = null,
                    modifier = Modifier
                        .width(240.dp)
                        .height(400.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Box(
                    modifier = Modifier
                        .width(350.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = 10.dp))
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .width(350.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(
                                        topStart = 10.dp,
                                        topEnd = 10.dp,
                                    )
                                )
                                .padding(10.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFF008000),
                                        shape = RoundedCornerShape(size = roundedSize)
                                    )
                                    .background(
                                        color = Color(0xFFF5F5FF),
                                        shape = RoundedCornerShape(size = roundedSize)
                                    )
                                    .width(100.dp)
                                    .height(35.dp)
                            ) {
                                Text(
                                    text = "Thức ăn",

                                    // Paragraf 1/Regular (12)
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF008000),
                                    )
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFEB9525),
                                        shape = RoundedCornerShape(size = roundedSize)
                                    )
                                    .background(
                                        color = Color(0xFFF5F5FF),
                                        shape = RoundedCornerShape(size = roundedSize)
                                    )
                                    .width(140.dp)
                                    .height(35.dp)
                            )
                            {
                                Text(
                                    text = "Được yêu thích",

                                    // Paragraf 1/Regular (12)
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFEB9525),
                                    )
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Thức ăn hạt mềm Zenith",

                                // Title/18/Medium
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF5D4037),
                                )
                            )
                            Text(
                                text = "45.000 đ",

                                // Title/18/Medium
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Right,
                                )
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Box(
                                modifier = Modifier.width(223.dp)
                            ) {
                                Text(
                                    text = "Nổi tiếng với đồ ăn cho chó con được yêu thích",

                                    // Body/12/Regular
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 18.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF555555),
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .width(25.dp)
                                    .height(25.dp)
                                    .background(color = colorResource(id = R.color.saddle_brown))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.minus),
                                    contentDescription = "image description",
                                    colorFilter = ColorFilter.tint(Color.White),
                                    modifier = Modifier
                                        .fillMaxSize()
                                );
                            }
                            Box(
                                modifier = Modifier
                                    .width(25.dp)
                                    .height(25.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(4.dp)
                                    )

                            ) {
                                Text(
                                    text = "1",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        lineHeight = 26.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF3C3C3C),
                                        textAlign = TextAlign.Center,
                                    ),
                                    color = Color.Black,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .width(25.dp)
                                    .height(25.dp)
                                    .background(color = colorResource(id = R.color.saddle_brown))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.plus),
                                    contentDescription = "image description",
                                    colorFilter = ColorFilter.tint(Color.White),
                                    modifier = Modifier
                                        .fillMaxSize()
                                );
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .width(350.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(
                                        bottomStart = 10.dp,
                                        bottomEnd = 10.dp
                                    )
                                )
                                .padding(10.dp)
                        ) {
                            Image(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                colorFilter = ColorFilter.tint(Color.Yellow)
                            )

                            Text(
                                text = "4.9",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF5D4037),
                                )
                            )
                            Text(
                                text = "(23)",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight.Thin,
                                    color = Color(0xFF5D4037),
                                )
                            )
                            Text(
                                text = "Đánh giá",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight.Thin,
                                    color = Color(0xFF5D4037),
                                )
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                painter = painterResource(id = R.drawable.fav),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(start = 8.dp)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .width(350.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(vertical = 10.dp)
                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = 10.dp))
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Tùy chỉnh",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Vị",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "Cá hồi",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "Bò",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Kích cỡ",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "0.5kg",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "1kg",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "2kg",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .width(350.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(vertical = 10.dp)
                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = 10.dp))
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Thông tin sản phẩm",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                0.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.product_description),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .background(
                        color = Color.White,
                    )
            ) {
                Box(
                    modifier = Modifier
                        .width(350.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = 10.dp))
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .width(350.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(
                                        topStart = 10.dp,
                                        topEnd = 10.dp,
                                    )
                                )
                                .padding(10.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFF008000),
                                        shape = RoundedCornerShape(size = roundedSize)
                                    )
                                    .background(
                                        color = Color(0xFFF5F5FF),
                                        shape = RoundedCornerShape(size = roundedSize)
                                    )
                                    .width(100.dp)
                                    .height(35.dp)
                            ) {
                                Text(
                                    text = "Thức ăn",

                                    // Paragraf 1/Regular (12)
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF008000),
                                    )
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFEB9525),
                                        shape = RoundedCornerShape(size = roundedSize)
                                    )
                                    .background(
                                        color = Color(0xFFF5F5FF),
                                        shape = RoundedCornerShape(size = roundedSize)
                                    )
                                    .width(140.dp)
                                    .height(35.dp)
                            )
                            {
                                Text(
                                    text = "Được yêu thích",

                                    // Paragraf 1/Regular (12)
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFEB9525),
                                    )
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Thức ăn hạt mềm Zenith",

                                // Title/18/Medium
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF5D4037),
                                )
                            )
                            Text(
                                text = "45.000 đ",

                                // Title/18/Medium
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Right,
                                )
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Box(
                                modifier = Modifier.width(223.dp)
                            ) {
                                Text(
                                    text = "Nổi tiếng với đồ ăn cho chó con được yêu thích",

                                    // Body/12/Regular
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        lineHeight = 18.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF555555),
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .width(25.dp)
                                    .height(25.dp)
                                    .background(color = colorResource(id = R.color.saddle_brown))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.minus),
                                    contentDescription = "image description",
                                    colorFilter = ColorFilter.tint(Color.White),
                                    modifier = Modifier
                                        .fillMaxSize()
                                );
                            }
                            Box(
                                modifier = Modifier
                                    .width(25.dp)
                                    .height(25.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(4.dp)
                                    )

                            ) {
                                Text(
                                    text = "1",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        lineHeight = 26.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF3C3C3C),
                                        textAlign = TextAlign.Center,
                                    ),
                                    color = Color.Black,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .width(25.dp)
                                    .height(25.dp)
                                    .background(color = colorResource(id = R.color.saddle_brown))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.plus),
                                    contentDescription = "image description",
                                    colorFilter = ColorFilter.tint(Color.White),
                                    modifier = Modifier
                                        .fillMaxSize()
                                );
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .width(350.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(
                                        bottomStart = 10.dp,
                                        bottomEnd = 10.dp
                                    )
                                )
                                .padding(10.dp)
                        ) {
                            Image(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                colorFilter = ColorFilter.tint(Color.Yellow)
                            )

                            Text(
                                text = "4.9",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF5D4037),
                                )
                            )
                            Text(
                                text = "(23)",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight.Thin,
                                    color = Color(0xFF5D4037),
                                )
                            )
                            Text(
                                text = "Đánh giá",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 26.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight.Thin,
                                    color = Color(0xFF5D4037),
                                )
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                painter = painterResource(id = R.drawable.fav),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(start = 8.dp)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .width(350.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(vertical = 10.dp)
                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = 10.dp))
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Tùy chỉnh",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Vị",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "Cá hồi",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "Bò",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Kích cỡ",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "0.5kg",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "1kg",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(30.dp)
                                    .border(
                                        width = 2.dp,
                                        color = colorResource(id = R.color.saddle_brown),
                                        shape = RoundedCornerShape(roundedSize)
                                    )
                            ) {
                                Text(
                                    text = "2kg",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(600),
                                        color = colorResource(id = R.color.saddle_brown),
                                    ),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .width(350.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 10.dp)
                        )
                        .padding(vertical = 10.dp)
                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(size = 10.dp))
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                11.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "Thông tin sản phẩm",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                0.dp,
                                Alignment.Start
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.product_description),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    color = Color(0xFF3C3C3C),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    alpha = (scrollState.value.toFloat() / scrollState.maxValue) * 2
                }
                .background(color = Color.White)
        )
        {
            PetShopAppBar(title = "Thức ăn hạt mầm Zenith")
        }
    }
}


@Preview
@Composable
fun ProductDettailPreview() {
    ProDuctDetail()
}
