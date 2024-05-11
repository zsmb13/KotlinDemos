package com.jetbrains.demo

import Calculator
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var input by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }

        Column(
            Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircleLogo(Modifier.padding(32.dp))
            TextField(input, onValueChange = { input = it }, label = { Text("Enter circle radius") })
            OutlinedButton(onClick = {
                val area = Calculator().circleArea(input.toDoubleOrNull() ?: 0.0)
                result = area.toString()
            }) {
                Text("Calculate!")
            }
            if (result.isNotBlank()) {
                Text("Area: $result")
            }
        }
    }
}

@Composable
private fun CircleLogo(modifier: Modifier = Modifier) {
    val brush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFFBE18E6),
                Color(0xFF5C9EE8),
                Color(0xFF7AC300),
                Color(0xFFEF8539),
                Color(0xFFBE18E6),
            )
        )
    }
    Box(
        modifier
            .drawBehind { drawCircle(brush, style = Stroke(100f)) }
            .size(160.dp)
    )
}
