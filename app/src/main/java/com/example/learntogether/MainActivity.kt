package com.example.learntogether

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    LearnTogetherLayout()
                }
            }
        }
    }
}

@Composable
fun TopImage() {
    val topImage = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = topImage,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(all = 16.dp),
        fontSize = 24.sp
    )
}

@Composable
fun Content() {
    Column() {
        Text(
            text = stringResource(id = R.string.learn_together_1st_para),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.learn_together_2st_para),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(all = 16.dp)
        )
    }
}

@Composable
fun LearnTogetherLayout() {
    Column {
        TopImage()
        Title(title = stringResource(R.string.learn_together_title))
        Content()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LearnTogetherLayoutPreview() {
    LearnTogetherTheme {
        LearnTogetherLayout()
    }
}