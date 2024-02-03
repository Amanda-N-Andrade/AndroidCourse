/*
 * Reference:
 * Google Developer Training. Basic Android Kotlin Compose Training Lemonade. GitHub.
 * Accessed on 2024-01-30.
 * Available at: https://github.com/google-developer-training/basic-android-kotlin-compose-training-lemonade
 *
 * This code is inspired by or based on the "Basic Android Kotlin Compose Training Lemonade" project
 * by Google Developer Training, available on GitHub. The original work can be found at the above URL.
 */

package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeGame()
                }
            }
        }
    }
}

@Composable
fun DisplayLemonadeStep(
    stepTextId: Int,
    imageResourceId: Int,
    imageDescriptionId: Int,
    onClickAction: () -> Unit
) {
    DisplayImageAndText(
        resourceId = imageResourceId,
        descriptionId = imageDescriptionId,
        textId = stepTextId,
        onClick = onClickAction
    )
}

@Composable
fun LemonadeGame() {
    var gameStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    val handleImageClick = {
        when (gameStep) {
            1 -> {
                gameStep = 2
                squeezeCount = (2..4).random()
            }
            2 -> {
                squeezeCount--
                if (squeezeCount <= 0) gameStep = 3
            }
            3 -> gameStep = 4
            4 -> gameStep = 1
        }
    }

    when (gameStep) {
        1 -> DisplayLemonadeStep(
            stepTextId = R.string.step_description_1,
            imageResourceId = R.drawable.lemon_tree,
            imageDescriptionId = R.string.content_desc_lemon_tree,
            onClickAction = handleImageClick
        )
        2 -> DisplayLemonadeStep(
            stepTextId = R.string.step_description_2,
            imageResourceId = R.drawable.lemon_squeeze,
            imageDescriptionId = R.string.content_desc_lemon,
            onClickAction = handleImageClick
        )
        3 -> DisplayLemonadeStep(
            stepTextId = R.string.step_description_3,
            imageResourceId = R.drawable.lemon_drink,
            imageDescriptionId = R.string.content_desc_lemonade_glass,
            onClickAction = handleImageClick
        )
        4 -> DisplayLemonadeStep(
            stepTextId = R.string.step_description_4,
            imageResourceId = R.drawable.lemon_restart,
            imageDescriptionId = R.string.content_desc_empty_glass,
            onClickAction = handleImageClick
        )
    }
}

@Composable
fun DisplayImageAndText(
    resourceId: Int,
    descriptionId: Int,
    textId: Int,
    onClick: () -> Unit
) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onClick,
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(id = resourceId),
                    contentDescription = stringResource(id = descriptionId),
                    modifier = Modifier.width(200.dp).height(200.dp).padding(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = stringResource(id = textId),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeGamePreview() {
    LemonadeTheme {
        DisplayLemonadeStep(
            stepTextId = R.string.step_description_1,
            imageResourceId = R.drawable.lemon_tree,
            imageDescriptionId = R.string.content_desc_lemon_tree,
            onClickAction = {}
        )
    }
}
