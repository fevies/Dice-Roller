package com.elvies.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elvies.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent  (

        ){
            DiceRollerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    DiceWithButtonAndImage()
                }
            }
        }
    }
}
//modifier:  a collection of elements that decorate or modify the behavior of Compose UI elements.


@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    //composable functions stores objects in memory using the remember composable
    //mutableStateOf() function returns an observable .(when the value of the result variable changes
    // a recomposition is triggered, the value of the result variable changes, a recomposition is
    // triggered , the value of result is reflected and the UI refreshes)

    var result by remember { mutableIntStateOf(1) }

    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { result = (1 .. 6).random() }
        ) {
            Text(stringResource(R.string.roll),
                fontSize = 24.sp)
        }
    }
}
//composable are stateless by default , which means that they don't hold a value and can be
//recomposed anytime by the system , which result in the value being reset.

@Preview
@Composable
fun DiceRollerPreview() {
    DiceWithButtonAndImage()

}




