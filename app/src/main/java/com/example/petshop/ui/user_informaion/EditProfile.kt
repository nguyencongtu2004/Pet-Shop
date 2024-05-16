package com.example.petshop.ui.user_informaion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshop.R
import com.example.petshop.model.User

@Composable
fun EditProfile(
    navController: NavController? = null,
    modifier: Modifier = Modifier,
    user: User = User()
) {
    val editedUser by remember { mutableStateOf(user) }

    var showEditDialog by remember { mutableStateOf(false) }
    var editField by remember { mutableStateOf("") }
    var editValue by remember { mutableStateOf("") }

    val openEditDialog: (String, String) -> Unit = { field, value ->
        editField = field
        editValue = value
        showEditDialog = true
    }

    if (showEditDialog) {
        AlertDialog(
            onDismissRequest = { showEditDialog = false },
            title = { Text(text = "Chỉnh sửa $editField") },
            text = {
                TextField(
                    value = editValue,
                    onValueChange = { editValue = it },
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { showEditDialog = false }
                ) {
                    Text("Lưu")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showEditDialog = false }
                ) {
                    Text("Hủy")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            //.background(Color.Transparent)
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        //.background(Color.White)
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(140.dp)
                            .clip(CircleShape)
                    ) {
                        Image(
                            painter = user.avatar ?: painterResource(id = R.drawable.avatar),
                            contentDescription = "User Avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    TextButton(
                        onClick = { /* Handle avatar edit */ },
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(
                            "Sửa",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(end = 4.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            }

            items(listOf(
                "Tên" to user.name,
                "Giới tính" to user.sex,
                "Ngày sinh" to user.birthday,
                "Số điện thoại" to user.phone,
                "Email" to user.email,
                "Địa chỉ" to user.address
            )) { (label, value) ->
                ProfileItem(label, value, openEditDialog)
            }
        }

        com.example.petshop.ui.login_register.Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp),
            onClick = { /*TODO*/ },
            title = "Xong",
            isDisable = false,
            color = Color(0xFF4CAF50)
        )
    }
}

@Composable
fun ProfileItem(label: String, value: String, onEdit: (String, String) -> Unit) {
    val iconSize = 24.dp

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            //.background(Color.White)
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .clickable { onEdit(label, value) }
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            ),
            modifier = Modifier.weight(1f)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(iconSize),
                tint = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun EditProfilePreview() {
    EditProfile()
}
