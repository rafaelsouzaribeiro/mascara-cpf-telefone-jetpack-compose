package com.example.mask

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mask.lib.MaskCpf
import com.example.mask.lib.MaskPhone
import com.example.mask.ui.theme.MaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MaskPhoneCPFScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MaskPhoneCPFScreen(modifier: Modifier = Modifier) {
    val visualTransformationPhone: VisualTransformation = remember { MaskPhone() }
    val visualTransformationCpf: VisualTransformation = remember { MaskCpf() }
    val textPhone = remember { mutableStateOf("") }
    val textCpf = remember { mutableStateOf("") }
    val mod=modifier.fillMaxWidth().padding(16.dp)

    Column(
        modifier = mod
    ) {

        TextField(
            value = textPhone.value,
            onValueChange = { newValue ->
                if (newValue.length<=11){
                   textPhone.value = newValue
                }

            },
            placeholder = { Text(text = "Digite o Telefone") },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorCursorColor = Color.Red,
                cursorColor = Color.Red
            ),
            visualTransformation = visualTransformationPhone,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )


        TextField(
            value = textCpf.value,
            onValueChange = { newValue ->
                if (newValue.length<=11){
                    textCpf.value = newValue
                }

            },
            placeholder = { Text(text = "Digite o CPF") },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorCursorColor = Color.Red,
                cursorColor = Color.Red
            ),
            visualTransformation = visualTransformationCpf,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        val transformedCpf =
            visualTransformationCpf.filter(AnnotatedString(textCpf.value)).text.text
        val transformedPhone =
            visualTransformationPhone.filter(AnnotatedString(textPhone.value)).text.text

        Text(text = "CPF: $transformedCpf",modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp))
        Text(text = "TELEFONE: $transformedPhone")
    }


}


