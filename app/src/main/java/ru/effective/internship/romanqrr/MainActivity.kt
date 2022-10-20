package ru.effective.internship.romanqrr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent;
import ru.effective.internship.romanqrr.models.HeroItemUi
import ru.effective.internship.romanqrr.ui.ChooseHeroScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Create the list of heroes with their image ID's
        val heroList = listOf<HeroItemUi>(
            HeroItemUi("IronMan", R.drawable.ironman),
            HeroItemUi("SpiderMan", R.drawable.spiderman),
            HeroItemUi("Hulk", R.drawable.hulk),
            HeroItemUi("Captain America", R.drawable.captainamerica),
        )
        setContent {
            //Show the screen that let's user chose between different heroes
            ChooseHeroScreen(heroList = heroList, R.drawable.marvel)
        }
    }
}

























