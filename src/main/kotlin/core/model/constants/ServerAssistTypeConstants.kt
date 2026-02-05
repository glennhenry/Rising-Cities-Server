package core.model.constants

object ServerAssistTypeConstants {
    const val HARVEST_HELPER_RESIDENTIAL: String = "HARVEST_HELPER_RESIDENTIAL"
    const val EMERGENCY_SPAWNRATE: String = "EMERGENCY_SPAWNRATE"
    val ALL = setOf(
        HARVEST_HELPER_RESIDENTIAL,
        EMERGENCY_SPAWNRATE
    )
}
