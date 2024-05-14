package com.example.petshop.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.ui.theme.PetShopTheme

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

@Composable
fun TopAppBar(
    //modifier: Modifier = Modifier,
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

@Composable
fun BottomAppBar() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(22.dp, Alignment.End),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .height(64.dp)
            .background(color = Color(0xFFFEFEFE))
            .padding(start = 14.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(42.dp)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Tổng \nthanh toán:",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier
                    .width(88.dp)
                    .height(40.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "120.000 đ",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 20.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFF4141),
                ),

                )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(126.dp)
                    .height(48.dp)
                    .background(
                        color = Color(0xFFEE2828),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
            ) {
                Text(
                    text = "Mua hàng",

                    // Body/14/Medium
                    style = TextStyle(
                        fontSize = 14.sp,
                        //lineHeight = 20.sp,
                        //fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFEFEFE),
                        textAlign = TextAlign.Center,
                    )
                )
            }

        }
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar(title = "test")
}

@Preview
@Composable
fun BottomAppBarPreview() {
    BottomAppBar()
}

