package br.com.viniciusvianna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.viniciusvianna.ui.theme.AndroindComposeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroindComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App (modifier: Modifier = Modifier) {
    val message = remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Text(
            text = "Está com duvida?",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
        Text(
            text = "Faça uma pergunta e irei te ajudar a decidir",
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = message.value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Button(onClick = {
            val results = listOf("Comcerteza!", "Não conte com isso!", "Talvez!")
           val index = Random.Default.nextInt(results.size)
            message.value = results[index]
        }) { Text(text= "Perguntar") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroindComposeTheme {
        App()
    }
}