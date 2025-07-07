package com.example.cruditem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cruditem.ui.theme.CrudItemTheme
import com.example.cruditem.ui.view.ItemScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CrudItemTheme {
                Scaffold(
                    modifier = Modifier.fillMaxWidth(),
                    content = { paddingValues ->
                        ItemScreen(
                            modifier = Modifier
                                .padding(paddingValues)
                                .padding(top = 16.dp)
                        )
                    }

                )
            }
        }
    }
}