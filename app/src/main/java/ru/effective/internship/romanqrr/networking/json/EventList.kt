package ru.effective.internship.romanqrr.networking.json

data class EventList(
    val available : Int?,
    val returned : Int?,
    val collectionURI : String?,
    val items : List<EventSummary>?
)
