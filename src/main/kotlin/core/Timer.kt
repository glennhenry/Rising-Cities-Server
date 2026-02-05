package core

import io.ktor.util.date.getTimeMillis
import kotlin.time.Duration.Companion.minutes

/**
 * Quick timer usage.
 */
object Timer {
    fun now(): Long = getTimeMillis()
    fun minutesLater(min: Int): Long = getTimeMillis() + min.minutes.inWholeMinutes
    fun minutesAgo(min: Int): Long = getTimeMillis() - min.minutes.inWholeMinutes
}
