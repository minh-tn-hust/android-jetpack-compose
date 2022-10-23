package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, content: String, colorBackground: Color) {
    Box(
        modifier = Modifier.background(colorBackground).fillMaxWidth(fraction = 0.5f).fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(all = 16.dp).fillMaxHeight().fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.W500
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify
            )
        }
    }

}

@Composable
fun ComposeQuadrant() {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.Magenta)
    ) {
        Row(
            modifier = Modifier.weight(weight = 1f, fill = true).fillMaxHeight()
        ) {
            Quadrant(
                title = stringResource(R.string.quadrant1st_title),
                content = stringResource(R.string.quadrant1st_content),
                colorBackground = Color.Green
            )
            Quadrant(
                title = stringResource(R.string.quadrant2nd_title),
                content = stringResource(R.string.quadrant2nd_content),
                colorBackground = Color.Yellow
            )
        }
        Row(
            modifier = Modifier.weight(weight = 1f, fill = true).fillMaxHeight()
        ) {
            Quadrant(
                title = stringResource(R.string.quadrant3rd_title),
                content = stringResource(R.string.quadrant3rd_content),
                colorBackground = Color.Cyan,
            )
            Quadrant(
                title = stringResource(R.string.quadrant4th_title),
                content = stringResource(R.string.quadrant4th_content),
                colorBackground = Color.LightGray
            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ComposeQuadrantPreview() {
    LearnTogetherTheme {
        ComposeQuadrant()
    }
}