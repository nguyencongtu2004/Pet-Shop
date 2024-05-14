package com.example.petshop.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.R
import com.example.petshop.model.BottomNavigationBarItem

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
fun TopAppBarNoSearch(
    //modifier: Modifier = Modifier,
    title: String,
    onBackClick: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 14.dp, end = 16.dp, bottom = 14.dp)
    ) {
        IconButton(onClick = onBackClick) {
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




@Composable
fun PetShopBottomNavigationBar() {
    val selectedIndex = remember { mutableStateOf(0) }

    val items = listOf(
        BottomNavigationBarItem(
            label = "Trang chủ",
            selectIcon = painterResource(id = R.drawable.home_icon_selected),
            unSelectIcon = painterResource(id = R.drawable.home_icon_unselected)
        ),
        BottomNavigationBarItem(
            label = "Chat",
            selectIcon = painterResource(id = R.drawable.message_icon_unselected),
            unSelectIcon = painterResource(id = R.drawable.message_icon_unselected)
        ),
        BottomNavigationBarItem(
            label = "Tài khoản",
            selectIcon = painterResource(id = R.drawable.user_icon_selected),
            unSelectIcon = painterResource(id = R.drawable.user_icon_unselected)
        )
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        items.forEach { item ->
            val index = items.indexOf(item)
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = if (index == selectedIndex.value) item.selectIcon else item.unSelectIcon,
                        contentDescription = null,
                        tint = Color.Unspecified // Use Color.Unspecified to keep the original color of the icons
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        style = MaterialTheme.typography.labelMedium,
                        color = if (index == selectedIndex.value) Color(0xFF5D4037) else Color.Gray
                    )
                },
                selected = (index == selectedIndex.value),
                onClick = {
                    selectedIndex.value = index
                    // chuyển trang
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF5D4037),
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color(0xFF5D4037),
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.White
                )
            )
        }
    }
}

@Composable
fun TopAppBarWithSearch(
    onSearchTextChanged: (String) -> Unit,
    onSearchIconClicked: () -> Unit,
    filterClicked: () -> Unit,
    notificationClicked: () -> Unit,
    cartClicked: () -> Unit,
    searchText: String = ""
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 8.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.White, RoundedCornerShape(16.dp))
                //.border(1.dp, Color(0xFFCACACA), RoundedCornerShape(16.dp))
                .padding(horizontal = 8.dp) // Padding inside the box
        ) {
            Column {
                Spacer(modifier = Modifier.height(9.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .background(Color.Transparent, RoundedCornerShape(16.dp))
                        .border(1.dp, Color(0xFFCACACA), RoundedCornerShape(16.dp))

                        // nền trong suốt
                        .background(Color.Transparent)
                )
            }
            OutlinedTextField(
                value = searchText,
                onValueChange = onSearchTextChanged,
                maxLines = 1,
                textStyle = MaterialTheme.typography.bodyMedium,
                placeholder = {
                    Text(
                        "Tìm kiếm",
                        style = MaterialTheme.typography.bodyMedium
                            .copy(color = Color(0xFFCACACA))
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        // Đóng bàn phím khi nhấn search
                        keyboardController?.hide()
                    },
                ),
                leadingIcon = {
                    IconButton(
                        onClick = onSearchIconClicked,
                        modifier = Modifier.padding(0.dp),
                    ) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = Color(0xFF5D4037),
                            modifier = Modifier.padding(0.dp),
                        )
                    }
                },
                // làm mờ viền để tự thêm viền của mình
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp) // Remove padding from the TextField itself
            )
        }

        IconButton(onClick = filterClicked) {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Lọc",
                tint = Color(0xFF5D4037),
            )
        }
        IconButton(onClick = notificationClicked) {
            Icon(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = "Thông báo",
                tint = Color(0xFF5D4037),
            )
        }
        IconButton(onClick = cartClicked) {
            Icon(
                painter = painterResource(id = R.drawable.shopping_cart),
                contentDescription = "Giỏ hàng",
                tint = Color(0xFF5D4037),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetShopTopAppBarPreview() {
    TopAppBarWithSearch(
        filterClicked = { /*TODO*/ },
        notificationClicked = { /*TODO*/ },
        cartClicked = { /*TODO*/ },
        onSearchIconClicked = { /*TODO*/ },
        onSearchTextChanged = { /*TODO*/ }
    )
}

@Preview(showBackground = true)
@Composable
fun PetShopBottomNavigationItemPreview() {
    PetShopBottomNavigationBar()
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBarNoSearch(title = "test")
}

@Preview
@Composable
fun BottomAppBarPreview() {
    BottomAppBar()
}

