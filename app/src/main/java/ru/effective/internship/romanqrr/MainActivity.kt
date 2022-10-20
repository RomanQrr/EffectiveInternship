package ru.effective.internship.romanqrr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent;
import ru.effective.internship.romanqrr.models.HeroItemUi
import ru.effective.internship.romanqrr.ui.ChooseHeroScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val heroList = listOf<HeroItemUi>(
            HeroItemUi("IronMan", R.drawable.ironman),
            HeroItemUi("SpiderMan", R.drawable.spiderman),
            HeroItemUi("Hulk", R.drawable.hulk),
            HeroItemUi("Captain America", R.drawable.captainamerica),
        )
        setContent {
            ChooseHeroScreen(heroList = heroList, R.drawable.marvel)
        }
    }
}

























