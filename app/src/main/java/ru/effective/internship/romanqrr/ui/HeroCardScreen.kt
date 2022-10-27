package ru.effective.internship.romanqrr.ui


import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.effective.internship.romanqrr.models.HeroModel

@Composable
fun HeroCardScreen(hero: HeroModel, navController: NavHostController){

    Box {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(hero.imageURL)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = hero.imageID),
            contentDescription = null,
            modifier = Modifier.sizeIn(minWidth = 300.dp, minHeight = 600.dp)
                .fillMaxSize(),
        )
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(text = "Back.")
        }
        Text(text = hero.name,
            modifier = Modifier.align(Alignment.TopEnd))
        Text(text = hero.description,
            modifier = Modifier.align(Alignment.BottomEnd))
    }


}