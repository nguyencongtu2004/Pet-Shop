package com.example.petshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun Information(){
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start, // Căn lề trái
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Text(
            text = "Thông tin người nhận",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF3C3C3C),
            ),
            modifier = Modifier.padding(start = 8.dp) // Thêm padding từ bên trái
        )

        Text(
            text = "Nguyễn Công Tú",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF555555),
            ),
            modifier = Modifier.padding(start = 8.dp) // Thêm padding từ bên trái
        )

        Text(
            text = "0932564789",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF555555),
            ),
            modifier = Modifier.padding(start = 8.dp) // Thêm padding từ bên trái
        )

        Divider(
            modifier = Modifier
                .background(color = Color(0xFFEFEBE9))
        )

        Text(
            text = "Địa chỉ",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF3C3C3C),
            ),
            modifier = Modifier.padding(start = 8.dp) // Thêm padding từ bên trái
        )

        Text(
            text = "Thôn Cành Lá, Xã Cành Cây, Huyện Gió Mây, Tỉnh Đồi Núi",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF555555),
            ),
            modifier = Modifier.padding(start = 8.dp) // Thêm padding từ bên trái
        )



        Row {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(72.dp)
                    .height(18.dp)
            ) {
                Row {

                    Text(
                        text = "Chỉnh sửa",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 18.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF5D4037),
                        ),
                        modifier = Modifier
                            .width(52.dp)
                            .height(18.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.edit2),
                        contentDescription = "image description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .padding(3.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Delivery(){
    Column (
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start, // Căn lề trái
        modifier = Modifier.padding(horizontal = 12.dp)){
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Phương thức giao hàng",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF3C3C3C),
                )
            )

            Text(
                text = "*Chúng tôi mở cửa từ 8:00 - 18:00",

                // Body/12/Regular
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF555555),
                )
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Row {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ){
                    Text(
                        text = "Hỏa tốc",

                        // Body/14/Medium
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF3C3C3C),
                        )
                    )

                    Text(
                        text = "Khoảng 30 phút",

                        // Body/12/Regular
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF555555),
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                RadioButton(
                    selected = false,

                    onClick = { /*TODO*/ }
                )
            }

            Divider()

            Row {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ){
                    Text(
                        text = "Thường",

                        // Body/14/Medium
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF3C3C3C),
                        )
                    )

                    Text(
                        text = "Khoảng 1 đến 2 ngày",

                        // Body/12/Regular
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF555555),
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                RadioButton(
                    selected = false,
                    onClick = {/*TO DO*/ }
                )
            }

            Divider()


        }


        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Row {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ){
                    Text(
                        text = "Phương thức thanh toán",

                        // Body/14/Medium
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF3C3C3C),
                        )
                    )

                    Text(
                        text = "Thanh toán trực tiếp",

                        // Body/12/Regular
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF555555),
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Delete icon"
                    )
                }
            }

            Divider()

            Row {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ){
                    Text(
                        text = "Voucher",

                        // Body/14/Medium
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF3C3C3C),
                        )
                    )

                    Text(
                        text = "Không có voucher nào được thêm",

                        // Body/12/Regular
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF555555),
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Delete icon"
                    )
                }
            }

            Divider()

            Spacer(modifier = Modifier.height(10.dp))

            Divider(modifier = Modifier
                .width(375.dp)
                .height(4.dp)
                .background(color = Color(0xFFEFEBE9)))

        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start, // Căn lề trái
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Text(
            text = "Chi tiết thanh toán",

            // Body/14/Medium
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                //fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(500),
                color = Color(0xFF3C3C3C),
            )
        )

        Column {
            Row {
                Column {
                    Text(
                        text = "Tổng tiền hàng",

                        // Body/14/Regular
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF555555),
                        )
                    )

                    Text(
                        text = "(1 sản phẩm)",

                        // Body/10/Regular
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 14.sp,
                            //fontFamily = FontFamily(Font(R.font.poppins)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF555555),
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "45.000 đ",

                    // Body/14/Regular
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        //fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF555555),
                        textAlign = TextAlign.Right,
                    )
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "Phí vận chuyển",

                // Body/14/Regular
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF555555),
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "12.000 đ",

                // Body/14/Regular
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF555555),
                    textAlign = TextAlign.Right,
                )
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(138.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            Text(
                text = "Tổng cộng",

                // Body/14/Medium
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF3C3C3C),
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "57.000 đ",

                // Body/14/Medium
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF3C3C3C),
                    textAlign = TextAlign.Right,
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InforPreview() {

}