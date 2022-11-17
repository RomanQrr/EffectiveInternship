package ru.effective.internship.romanqrr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import ru.effective.internship.romanqrr.ui.ChooseHeroScreen
import ru.effective.internship.romanqrr.viewModels.HeroesViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Create the list of heroes with their image ID's
        val viewModel = HeroesViewModel()
        viewModel.fetchHeroList()
        setContent {
            //Show the screen that let's user chose between different heroes
            ChooseHeroScreen(viewModel, R.drawable.marvel)
        }
    }
}