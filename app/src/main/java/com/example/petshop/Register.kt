package com.example.petshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petshop.ui.theme.PetShopTheme

@Composable
fun Register(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp)
                    .weight(1f)

            ) {
                var sdtText by remember { mutableStateOf("") }
                var nameText by remember { mutableStateOf("") }

                Logo()
                Spacer(modifier = Modifier.height(8.dp))
                TypingNameField(
                    value = nameText,
                    onValueChange = { newText -> nameText = newText }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TypingSdtField(
                    value = sdtText,
                    onValueChange = { newText -> sdtText = newText }
                )
                Spacer(modifier = Modifier.height(28.dp))
                Button(
                    title = "Đăng ký",
                    isDisable = if (sdtText == "" || nameText == "") true else false,
                    onClick = {
                        println(nameText)
                        println(sdtText)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
            }
            Row {
                Text(
                    text = "Đã có tài khoản?",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = " Đăng nhập",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    ),
                    modifier = Modifier.clickable { }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TypingNameField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Tên",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(horizontal = 20.dp),
        )
        Spacer(modifier = Modifier.height(4.dp))
        val keyboardController = LocalSoftwareKeyboardController.current // để ẩn bàn phím
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = "Nhập tên của bạn")
            },
            shape = RoundedCornerShape(16.dp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
        )
    }
}

@Preview
@Composable
fun RegisterPreview() {
    PetShopTheme {
        Register()
    }
}