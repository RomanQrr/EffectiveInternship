package ru.effective.internship.romanqrr.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import ru.effective.internship.romanqrr.models.HeroModel

@OptIn(ExperimentalSnapperApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun ChooseHeroScreen(heroList : List<HeroModel>, logoId : Int){
    //Create value to use for snappers in 2 different places.
    val lazyRowState = rememberLazyListState();
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "chooseHero") {
        composable("chooseHero") {
            Column {
                Image(
                    painter = painterResource(id = logoId),
                    contentDescription = "Marvel Studio logo",
                    Modifier.background(Color.Black)
                )
                Text(
                    text = "Choose your hero",
                    color = Color.White,
                    fontSize = 8.em,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                LazyRow(
                    state = lazyRowState,
                    flingBehavior = rememberSnapperFlingBehavior(lazyRowState),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                )
                {
                    items(count = heroList.size) { index ->
                        Card(onClick = {
                            navController.navigate("chooseHero/${heroList[index].name}")
                        },
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(heroList[index].imageURL)
                                    .crossfade(true)
                                    .build(),
                                placeholder = painterResource(id = heroList[index].imageID),
                                contentDescription = null,
                                modifier = Modifier.sizeIn(minWidth = 300.dp, minHeight = 600.dp)
                                    .fillMaxSize(),
                            )
                            Text(
                                text = heroList[index].name,
                                fontSize = 6.em,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                                    .padding(8.dp)
                                    .wrapContentSize(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
        for(hero in heroList){
            composable("chooseHero/${hero.name}") {
                HeroCardScreen(hero = hero, navController)
            }
        }
    }
}