package com.example.screen22


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screen22.ui.theme.Screen22Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen22Theme {
                MedicalAppointmentScreen()
            }
        }
    }
}

@Composable
fun MedicalAppointmentScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize()
        ) {
            // Header with logo and title
            MedicalHeader()

            Spacer(modifier = Modifier.height(48.dp))

            // Action button
            StartButton()

            Spacer(modifier = Modifier.weight(1f))

            // Terms and conditions
            TermsAndConditions()
        }
    }
}

@Composable
fun MedicalHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        // MATC Logo
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(MaterialTheme.shapes.large)
                .background(Color(0xFF0F4C81)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "MATC",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(24.dp))

        // Welcome text
        Text(
            text = "WELCOME TO MEDICAL APPOINTMENT FOR TREATMENT AND CONSULTATION",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun StartButton() {
    Button(
        onClick = { /* Handle navigation */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0F4C81),
            contentColor = Color.White
        )
    ) {
        Text(
            text = "LET'S START",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TermsAndConditions() {
    Text(
        text = buildAnnotatedString {
            append("By clicking \"LET'S START\", you agree to our ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Terms of Service")
            }
            append(" and acknowledge our ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Privacy Policy")
            }
        },
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        fontSize = 14.sp
    )
}

@Preview(showSystemUi = true)
@Composable
fun MedicalAppointmentPreview() {
    Screen22Theme {
        MedicalAppointmentScreen()
    }
}
