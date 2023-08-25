package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroesapp.model.HeroesRepo
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun HeroApp(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HeroesTopBar()
        }
    ) {
        val heroes = HeroesRepo.heroes
        HeroesScreen().HeroesList(heroes = heroes)
    }
}

@Composable
fun HeroesTopBar(modifier: Modifier = Modifier){
Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
) {
    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.subtitle1

    )
}
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroesAppTheme {
        HeroApp()
    }
}