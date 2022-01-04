package com.example.compose_part1

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.compose_part1.ui.theme.Compose_part1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_part1Theme {

                var x=true
                var array=ArrayList<String>()
                array.add("harry")
                array.add("harry")
                array.add("harry")
                array.add("harry")
                array.add("harry")
                array.add("harry")
                array.add("harry")
                array.add("harry")
                array.add("harry")


                // A surface container using the 'background' color from the theme
                androidx.compose.material.Surface() {
                        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {

                            Surface(color = MaterialTheme.colors.secondary) {
                                Row() {
                                    for(i in 0..array.size-1){
                                        if(x==true){
                                            Greeting(name = "harry $i",MaterialTheme.colors.secondary)
                                            x=false
                                        }else{
                                            Greeting(name = "harry $i")
                                            x=true
                                        }
                                    }

                                }
                                Column() {
                                    Modifier.weight(1f)
                                }
                            }
                        }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, color: androidx.compose.ui.graphics.Color =MaterialTheme.colors.primary) {
    Column(){
        Surface(
            modifier = androidx.compose.ui.Modifier
                .height(200.dp)
                .width(200.dp)
                .padding(5.dp)
                .weight(1f)
                ,
            color = color
        ) {
            Box(
                Modifier
                    .height(50.dp)
                    .width(150.dp),
                contentAlignment = Alignment.Center,

            ) {
                androidx.compose.material.Surface(color = Color(204, 148, 36, 255)) {
                    Row() {
                        Column() {
                            Text(text = name.repeat(5), modifier = Modifier
                                .padding(3.dp)
                                , color = Color(189, 43, 43, 255)
                                ,textAlign = TextAlign.Center,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.SemiBold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                        Column(){
                            Text(buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(58, 132, 206, 255),
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = FontFamily.SansSerif
                                    )
                                ){
                                    append("a")
                                }
                                append('b')
                                append('b')
                            })
                        }

                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_part1Theme {
        Column{
            Surface(
                modifier = androidx.compose.ui.Modifier
                    .height(50.dp)
                    .width(200.dp)
                    .weight(3f),
                color = MaterialTheme.colors.secondary
            ) {
                Text("welcome",textAlign = TextAlign.Center)
            }
            Surface(
                modifier = androidx.compose.ui.Modifier
                    .height(50.dp)
                    .width(200.dp)
                    .weight(4f),
                color = MaterialTheme.colors.primary
            ) {
                Text("welcome",textAlign = TextAlign.Center)
            }
            Surface(
                modifier = androidx.compose.ui.Modifier
                    .height(50.dp)
                    .width(200.dp)
                    .weight(1f),
                color = MaterialTheme.colors.primary
            ) {
                Text("welcome",textAlign = TextAlign.Center)
            }
        }
    }
}