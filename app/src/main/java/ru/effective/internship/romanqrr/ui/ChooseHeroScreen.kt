package ru.effective.internship.romanqrr.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import ru.effective.internship.romanqrr.models.HeroItemUi

@OptIn(ExperimentalSnapperApi::class)
@Composable
internal fun ChooseHeroScreen(heroList : List<HeroItemUi>, logoId : Int){
    val lazyRowState = rememberLazyListState();
    Column {
        Image(painter = painterResource(id = logoId),
            contentDescription = "Marvel Studio logo",
            Modifier.background(Color.Black))
        Text(text = "Choose your hero",
            color = Color.White,
            fontSize = 8.em,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        LazyRow(state = lazyRowState,
            flingBehavior = rememberSnapperFlingBehavior(lazyRowState),
            horizontalArrangement = Arrangement.spacedBy(20.dp))
        {
            items(count = heroList.size) { index ->
                Box {
                    Image(
                        painter = painterResource(id = heroList[index].imageID),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                    )
                    Text(
                        text = heroList[index].name,
                        fontSize = 6.em,
                        modifier = Modifier.align(Alignment.BottomCenter)
                            .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                            .padding(8.dp)
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}