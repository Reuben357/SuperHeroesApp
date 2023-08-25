package com.example.superheroesapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepo
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme
import java.nio.file.WatchEvent

class HeroesScreen {

    @Composable
    fun HeroesList(
        heroes: List<Hero>,
    ){
        LazyColumn{
            items(heroes){ hero ->
                HeroesCardItem(
                    hero = hero,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

    @Composable
    fun HeroesCardItem(
        hero: Hero,
        modifier: Modifier = Modifier
    ){
        Card (
            elevation = 2.dp,
            modifier = modifier,
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .sizeIn(minHeight = 72.dp)
            ) {
                Column (modifier = Modifier.weight(1f)){
                    Text(
                        text = stringResource(hero.name ),
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = stringResource(hero.description),
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(8.dp))
                ){
                    Image(
                        painter = painterResource(hero.imageRes ),
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
        }
    }

    @Preview("Heroes List")
    @Composable
    fun HeroesPreview() {
        Surface (
            ) {
                HeroesList(heroes = HeroesRepo.heroes)
            }
        }
    }

