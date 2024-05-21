@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class
)

package com.example.petshop.ui.user_informaion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshop.R
import com.example.petshop.model.User
import com.example.petshop.view_model.UserViewModel

@Composable
fun ProfileScreen(
    navController: NavController? = null,
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier,
    onEditProfileClicked: () -> Unit = {},
    onLoginClicked: () -> Unit = {},
    onShippingClicked: () -> Unit = {},
    onShippedClicked: () -> Unit = {},
    onEditAddressClicked: () -> Unit = {},
    onFavoriteProductClicked: () -> Unit = {},
    onShareAppClicked: () -> Unit = {},
    onShopInforClicked: () -> Unit = {},
    onAppInforClicked: () -> Unit = {},
    onLogoutClicked: () -> Unit = {},
    isSheetOpen: Boolean = false,
    onDismissRequset: () -> Unit = {},
    sheetState: SheetState,
    isShopInforSheetOpen: Boolean = false
) {
    val user by userViewModel.currentUser.collectAsState()

    Box(modifier = modifier.fillMaxWidth()) {
        if (isSheetOpen && isShopInforSheetOpen) {
            ModalBottomSheet(
                onDismissRequest = onDismissRequset,
                sheetState = sheetState,
            ) {
                ShopIntroduction()
            }
        } else if (isSheetOpen) {
            ModalBottomSheet(
                onDismissRequest = onDismissRequset,
                sheetState = sheetState,
                scrimColor = Color.Unspecified
            ) {
                AppIntroduction()
            }
        }

        LazyColumn {
            item {
                // Personal information
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = user.avatar),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(82.dp)
                                .height(82.dp)
                                .clip(CircleShape)
                        )
                    }
                    if (user.password != null)
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = user.name,
                                style = MaterialTheme.typography.displaySmall.copy(
                                    fontSize = 30.sp,
                                    color = Color(0xFF555555),
                                ),
                                modifier = Modifier.padding(vertical = 5.dp)
                            )
                            Text(
                                text = user.role,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = Color(0xFF48854B),
                                ),
                            )
                            Row(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(25.dp)
                                    .clickable { onEditProfileClicked() }
                            ) {
                                Text(
                                    text = "Chỉnh sửa",
                                    style = MaterialTheme.typography.labelMedium,
                                    modifier = Modifier.padding(vertical = 5.dp)
                                )
                                IconButton(
                                    onClick = { onEditProfileClicked() },
                                    modifier = Modifier.padding(all = 0.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = null,
                                        modifier = Modifier.padding(all = 0.dp)
                                    )
                                }
                            }
                        } else
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .clickable { onLoginClicked() }
                                .align(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = "Đăng nhập",
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF555555),
                                ),
                            )

                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(all = 0.dp)
                                    .width(40.dp)
                                    .height(40.dp)
                            )
                        }
                }
            }

            item {
                // Orders section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Text(
                        text = "Đơn hàng",
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontSize = 28.sp,
                        ),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    shape = RoundedCornerShape(size = 30.dp)
                                )
                                .width(160.dp)
                                .height(90.dp)
                                .clickable { onShippingClicked() }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.fi_truck),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
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
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.colorScheme.tertiaryContainer,
                                    shape = RoundedCornerShape(size = 30.dp)
                                )
                                .width(160.dp)
                                .height(90.dp)
                                .clickable { onShippedClicked() }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.fi_package),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                            )
                            Spacer(modifier = Modifier.height(5.dp))
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

            item {
                // Settings section
                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    SettingComponent(
                        text = "Sửa địa chỉ nhận hàng",
                        painter = painterResource(id = R.drawable.location),
                        onClick = { onEditAddressClicked() }
                    )
                    if (user.password != null) {
                        SettingComponent(
                            text = "Sản phẩm yêu thích",
                            painter = painterResource(id = R.drawable.fav),
                            onClick = { onFavoriteProductClicked() }
                        )
                    }
                    SettingComponent(
                        text = "Giới thiệu cho bạn bè",
                        painter = painterResource(id = R.drawable.ic_user),
                        onClick = { onShareAppClicked() }
                    )
                    SettingComponent(
                        text = "Thông tin cửa hàng",
                        painter = painterResource(id = R.drawable.shop_infor),
                        onClick = { onShopInforClicked() }
                    )
                    SettingComponent(
                        text = "Thông tin ứng dụng",
                        painter = painterResource(id = R.drawable.infor),
                        onClick = { onAppInforClicked() }
                    )
                    if (user.password != null) {
                        SettingComponent(
                            text = "Đăng xuất",
                            painter = painterResource(id = R.drawable.log_out),
                            color = Color.Red,
                            onClick = { onLogoutClicked() }
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Composable
fun SettingComponent(
    painter: Painter,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color = Color.Black
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(color),
            modifier = Modifier
                .padding(vertical = 10.dp)
                .width(30.dp)
                .height(30.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(
                color = color,
            ),
        )
    }
}

@Composable
fun ShopIntroduction(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.logo_tranfer),
            contentDescription = "Hình ảnh cửa hàng",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = "Chào mừng đến với Pet Shop",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Pet Shop  tôi cung cấp một loạt " +
                    "các sản phẩm để đáp ứng tất cả nhu cầu thú cưng của bạn. " +
                    "Từ các thực phẩm mới nhất đến các nhu yếu phẩm hàng ngày, " +
                    "chúng tôi đều có. Cam kết của chúng tôi là cung cấp sản phẩm chất " +
                    "lượng cao với giá cả phải chăng.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Tại sao nên chọn Pet Shop?",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "1. Sản phẩm chất lượng cao\n2. Giá cả phải chăng\n3. Dịch vụ khách hàng tuyệt vời\n4. Giao hàng nhanh chóng",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun AppIntroduction(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Pet Shop",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Đây là ứng dụng bán hàng online, là sản phẩm của môn học SE114 - Nhập môn ứng dụng di động do giảng viên Huỳnh Thị Hồ Mộng Trinh hướng dẫn và được phát triển bởi:\n" +
                    "      1. Nguyễn Anh Phi\n" +
                    "      2. Nguyễn Công Tú\n" +
                    "      3. Bế Ích Tuân\n" +
                    "      4. Võ Hoàng Tuấn\n" +
                    "      5. Nguyễn Phú Triệu \n" +
                    "Ứng dụng vẫn đang trong quá trình phát triển nên có thể xảy ra lỗi nào không mong muốn. Kính mong cô và các bạn góp ý.\n" +
                    "Nhóm chúng mình xin cảm ơn <3 !",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var isShopInforSheetOpen by rememberSaveable { mutableStateOf(false) }
    ProfileScreen(
        userViewModel = UserViewModel(),
        isSheetOpen = isSheetOpen,
        onDismissRequset = { isSheetOpen = false },
        sheetState = sheetState,
        isShopInforSheetOpen = isShopInforSheetOpen,
        onShopInforClicked = { isSheetOpen = true; isShopInforSheetOpen = true },
        onAppInforClicked = { isSheetOpen = true; isShopInforSheetOpen = false }
    )
}

