package com.example.androidassignmentfrontend

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidassignmentfrontend.ui.theme.AndroidAssignmentfrontendTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*var text by remember {
                mutableStateOf("")
            }*/
            AndroidAssignmentfrontendTheme {
                /*Column(modifier = Modifier.padding(20.dp)
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    TextField(value = text,
                        onValueChange = {text = it},
                        label = {Text("Username: ")}
                    )
                    Text (text)
                }*/
                ScaffoldTrial()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScaffoldTrial(){
    Scaffold(
        topBar = {
            TopAppBar(colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                titleContentColor = MaterialTheme.colorScheme.onSecondary
            ),
                title = { Text("MyTopBar") }
            )

        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ) {
               Text(text = "MyBottomBar") 
            }
        },
        floatingActionButton= {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Chat")
            }
        }
    ){

        innerPadding ->
        var sheetState= rememberModalBottomSheetState()
        var showBottomSheet by remember{
            mutableStateOf(false)
        }
        var showAlert by remember {
            mutableStateOf(false)
        }
        Column(modifier=Modifier.padding(innerPadding)) {
            Text(text = "This is me. I am neither Spiderman Nor Batman. But I am more dangerous because I can write anything inside these quotes that might be checke by my Teacher. Sorry in advance sir. Just a test quotes")
            Button(onClick = { showBottomSheet = true }) {
                Text("Click to open Bottom Sheet")
            }
            Button(onClick = { showAlert = true }) {
                Text(text = "Show Alert")
            }
        }
        if(showBottomSheet){
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet=false },
                sheetState=sheetState,
                containerColor = MaterialTheme.colorScheme.error
            ) {
               Column (
                   modifier= Modifier
                       .padding(10.dp)
                       .fillMaxSize()
               ){
                   Text(text = "Sorry again for the quotes sir")
               }
            }

        }
        if(showAlert){
            AlertDialogEx()
        }
        var text by remember {
            mutableStateOf("")
        }
        Column(modifier = Modifier.padding(20.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            TextField(value = text,
                onValueChange = {text = it},
                label = {Text("Username: ")}
            )
            Text (text)
        }


    }
}

@Composable
fun AlertDialogEx(){
    AlertDialog(
        icon={Icon(Icons.Filled.Done, contentDescription="Done")},
        title= {
            Text("Emergency")
        },
        text={
            Text(text="JetpackCompose is legit very easy. Most of the things is already provided by IDE")
        },onDismissRequest = { /*TODO*/ },

        confirmButton = {
            TextButton(onClick = { println("Clicked on text button") }) {
                Text(text = "Alright")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AlertDialogExPreview(){
    AlertDialogEx()
}

@Preview(showBackground = true)
@Composable
fun ScaffoldExamplePreview(){
    AndroidAssignmentfrontendTheme{
        ScaffoldTrial()
    }
}

