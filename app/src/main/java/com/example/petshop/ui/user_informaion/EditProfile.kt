package com.example.petshop.ui.user_informaion

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.petshop.R
import com.example.petshop.view_model.UserViewModel

/*
fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    return emailRegex.matches(email)
}
*/

@Composable
fun EditProfile(
    navController: NavController? = null,
    userViewModel: UserViewModel,
    modifier: Modifier = Modifier,
) {
    val user by userViewModel.currentUser.collectAsState()

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
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showEditDialog = false
                        userViewModel.updateUser(
                            user.copy(
                                name = if (editField == "Tên") editValue else user.name,
                                sex = if (editField == "Giới tính") editValue else user.sex,
                                birthday = if (editField == "Ngày sinh") editValue else user.birthday,
                                phone = if (editField == "Số điện thoại") editValue else user.phone,
                                email = if (editField == "Email") editValue else user.email,
                                address = if (editField == "Địa chỉ") editValue else user.address
                            )
                        )
                    }
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
                            painter = painterResource(id = user.avatar),
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

            items(
                listOf(
                    "Tên" to user.name,
                    "Giới tính" to user.sex,
                    "Ngày sinh" to user.birthday,
                    "Số điện thoại" to user.phone,
                    "Email" to user.email,
                    "Địa chỉ" to user.address
                )
            ) { (label, value) ->
                ProfileItem(label, value, openEditDialog)
            }
        }

        com.example.petshop.ui.login_register.Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp),
            onClick = {
                navController?.popBackStack()
            },
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
            //modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
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
                textAlign = TextAlign.End,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
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
    EditProfile(userViewModel = UserViewModel())
}
