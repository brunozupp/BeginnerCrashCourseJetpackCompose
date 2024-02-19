package com.novelitech.beginnercrashcoursejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novelitech.beginnercrashcoursejetpackcompose.ui.theme.BeginnerCrashCourseJetpackComposeTheme
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            challenge()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun challenge() {
        BeginnerCrashCourseJetpackComposeTheme {

            var name by remember {
                mutableStateOf("")
            }

            var names by remember {
                mutableStateOf(listOf<String>())
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        value = name,
                        onValueChange = { text ->
                            name = text
                        },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(
                       modifier = Modifier.width(16.dp)
                    )
                    Button(
                        onClick = {
                            if(name.isNotBlank()) {
                                names = names + name

                                name = ""
                            }
                        }
                    ) {
                        Text(
                            text = "Add"
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                NameList(
                    names = names,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )

//                LazyColumn {
//                    items(names) { currentName ->
//                        Text(
//                            text = currentName,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 16.dp)
//                        )
//                        if(names.lastOrNull() != currentName) {
//                            Divider()
//                        }
//                    }
//                }
            }
        }
    }

    @Composable
    fun NameList(
        names: List<String>,
        modifier: Modifier,
    ) {
        LazyColumn {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    modifier = modifier
                )
                if(names.lastOrNull() != currentName) {
                    Divider()
                }
            }
        }
    }

    @Composable
    fun counterExample() {
        BeginnerCrashCourseJetpackComposeTheme {

            // Using 'by' I skip the .value and can access the value of the variable directly
            var count by remember {
                mutableStateOf(0)
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = count.toString(),
                    fontSize = 30.sp
                )
                Button(
                    onClick = {
                        count++
                    }
                ) {
                    Text(
                        text = "Click Me Here!"
                    )
                }
            }
        }
    }
}
