package com.androidapp.assigment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidapp.assigment1.ui.theme.Assigment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assigment1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize().fillMaxHeight(),
                    color = Color.LightGray
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Profile part
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .border(2.dp, Color.LightGray)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(150.dp)
                    .border(2.dp, Color.Transparent)
                    .background(Color.LightGray)
                    .align(CenterHorizontally)
            )
            Text(
                text = "Amanda Andrade",
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 32.sp
            )
            Text(
                text = "Software Developer",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(CenterHorizontally),
                color = Color.Green,
                fontSize = 20.sp
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .border(2.dp, Color.LightGray)
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Text(text = "Contact", fontWeight = FontWeight.SemiBold, style = MaterialTheme.typography.titleMedium)

            // Row for email
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "amanda.n.andrade@outlook.com", style = MaterialTheme.typography.bodyMedium)
            }

            // Row for phone
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Phone Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "+ 1(403) 681-7728", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview
@Composable
fun PreviewBusinessCard() {
    Surface(
        modifier = Modifier.fillMaxSize().fillMaxHeight(),
        color = Color.LightGray
    ){
        BusinessCardApp()
    }

}