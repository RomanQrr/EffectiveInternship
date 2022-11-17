package ru.effective.internship.romanqrr.networking.json

data class CharacterDataContainer(
    val offset : Int?,
    val limit : Int?,
    val total : Int?,
    val count : Int?,
    val results : List<Character>?
)