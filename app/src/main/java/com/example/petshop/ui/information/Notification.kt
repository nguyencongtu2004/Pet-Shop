package com.example.petshop.ui.information

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.ui.theme.PetShopTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.petshop.R


@Composable
fun Notification(title: String, description: String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(14.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.notiication_bell),
                contentDescription = "image description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(52.dp)
                    .height(52.dp)
            )
        }
        Column {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 26.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            Text(
                text = description,
                style = TextStyle(
                    fontSize = 10.sp,
                    lineHeight = 10.sp,
                    //fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF000000),
                )
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationDemo() {
    PetShopTheme {
        Notification(title = "test", description = "nothing")
    }
}