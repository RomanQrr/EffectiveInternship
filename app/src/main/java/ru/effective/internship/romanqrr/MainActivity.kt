package ru.effective.internship.romanqrr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import ru.effective.internship.romanqrr.models.HeroModel
import ru.effective.internship.romanqrr.ui.ChooseHeroScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Create the list of heroes with their image ID's
        val heroList = listOf(
            HeroModel("IronMan", R.drawable.ironman, "Ironman Description",
            "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/a/a0/Iron_Man_Armor_-_Mark_L.png/revision/latest/scale-to-width-down/240?cb=20180318221316"),
            HeroModel("SpiderMan", R.drawable.spiderman, "Spooderman description",
            "https://upload.wikimedia.org/wikipedia/en/2/21/Web_of_Spider-Man_Vol_1_129-1.png"),
            HeroModel("Hulk", R.drawable.hulk, "Hulk Smash!!!",
                "https://static.wikia.nocookie.net/a4a68960-de29-4c3c-8b97-8005ebc6b06c/scale-to-width/755"),
            HeroModel("Captain America", R.drawable.captainamerica, "'Merica. F yeah!",
            "https://static.wikia.nocookie.net/avengers-assemble/images/e/ea/Revo-Cap.png/revision/latest/scale-to-width-down/300?cb=20170615073447"),
        )
        setContent {
            //Show the screen that let's user chose between different heroes
            ChooseHeroScreen(heroList = heroList, R.drawable.marvel)
        }
    }
}