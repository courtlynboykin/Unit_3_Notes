package com.example.unit3notes

data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

enum class Daypart {MORNING, AFTERNOON, EVENING}

val kotlin = Event(
    title = "Study Kotlin",
    description = "Commit to studying Kotlin at least 15 minutes per day.",
    daypart = Daypart.EVENING,
    durationInMinutes = 15
)

val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

val events = listOf(event1, event2, event3, event4, event5, event6)

val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    val short = events.filter {
        it.durationInMinutes < 60
    }
    println(short.size)

    val daypartGroup = events.groupBy {
        it.daypart
    }
//   val morning = daypartGroup[Daypart.MORNING] ?: listOf()
//   val afternoon = daypartGroup[Daypart.AFTERNOON] ?: listOf()
//   val evening = daypartGroup[Daypart.EVENING] ?: listOf()

//   println()

//   println("Morning: ${morning.size} events")
//   println("Afternoon: ${afternoon.size} events")
//   println("Afternoon: ${evening.size} events")
    daypartGroup.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
    println("Last event of the day: ${events.last().title}")
}