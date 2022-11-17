package ru.effective.internship.romanqrr.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.effective.internship.romanqrr.R
import ru.effective.internship.romanqrr.models.HeroModel
import ru.effective.internship.romanqrr.networking.APIKey
import ru.effective.internship.romanqrr.networking.MarvelAPI

class HeroesViewModel : ViewModel() {
    var heroList = listOf(
        HeroModel("IronMan", R.drawable.ironman, "Ironman Description",
            "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/a/a0/Iron_Man_Armor_-_Mark_L.png/revision/latest/scale-to-width-down/240?cb=20180318221316"),
        HeroModel("SpiderMan", R.drawable.spiderman, "Spooderman description",
            "https://upload.wikimedia.org/wikipedia/en/2/21/Web_of_Spider-Man_Vol_1_129-1.png"),
        HeroModel("Hulk", R.drawable.hulk, "Hulk Smash!!!",
            "https://static.wikia.nocookie.net/a4a68960-de29-4c3c-8b97-8005ebc6b06c/scale-to-width/755"),
        HeroModel("Captain America", R.drawable.captainamerica, "'Merica. F yeah!",
            "https://static.wikia.nocookie.net/avengers-assemble/images/e/ea/Revo-Cap.png/revision/latest/scale-to-width-down/300?cb=20170615073447"),
    )
    fun fetchHeroList(){
        viewModelScope.launch {
            val lastResult = MarvelAPI.retrofitService.getHeroes(APIKey.privateKey)
            if(lastResult.data?.results != null && lastResult.data.count != null){
                val tempList = ArrayList<HeroModel>(lastResult.data.count)
                lastResult.data.results.forEachIndexed{
                    index, hero ->
                    val imageURL : String = if(hero.thumbnail?.extension == null){
                        "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg"
                    } else{
                        hero.thumbnail.extension + hero.thumbnail.path
                    }
                    tempList[index] = HeroModel(hero.name?: "", 0, hero.description?:"", imageURL)
                }
                heroList = tempList
            }
        }
    }
}