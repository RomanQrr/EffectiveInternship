package ru.effective.internship.romanqrr.networking.json

data class ComicList(
    val available : Int?,
    val returned : Int?,
    val collectionURI : String?,
    val items : List<ComicSummary>?
)
