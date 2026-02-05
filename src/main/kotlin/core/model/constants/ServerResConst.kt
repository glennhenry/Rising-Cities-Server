package core.model.constants

/**
 * Resource constants
 *
 * from `ServerResConst.as`
 */
@Suppress("Unused", "SpellCheckingInspection")
object ServerResConst {
    const val RESOURCE_EXPERIENCE: String = "RES_XP"
    const val RESOURCE_VIRTUALCURRENCY: String = "CURR_VIRT"
    const val RESOURCE_REALCURRENCY: String = "CURR_REAL"
    const val RESOURCE_ENERGY_POSITIVE: String = "RES_ENERGY_POSITIVE"
    const val RESOURCE_ENERGY_NEGATIVE: String = "RES_ENERGY_NEGATIVE"
    const val RESOURCE_HAPPINESS_POSITIVE: String = "RES_MOOD_POSITIVE"
    const val RESOURCE_HAPPINESS_NEGATIVE: String = "RES_MOOD_NEGATIVE"
    const val RESOURCE_POPULATION: String = "POPULATION"
    const val RESOURCE_WORKERS: String = "POP_WORKER"
    const val RESOURCE_RICHMEN: String = "POP_RICH"
    const val RESOURCE_ACADEMICS: String = "POP_TEACHER"
    const val RESOURCE_PRODUCTIONPOINTS: String = "CURR_PROD"
    const val RESOURCE_EDUCATIONPOINTS: String = "CURR_EDUC"
    val ALL = setOf(
        RESOURCE_EXPERIENCE,
        RESOURCE_VIRTUALCURRENCY,
        RESOURCE_REALCURRENCY,
        RESOURCE_ENERGY_POSITIVE,
        RESOURCE_ENERGY_NEGATIVE,
        RESOURCE_HAPPINESS_POSITIVE,
        RESOURCE_HAPPINESS_NEGATIVE,
        RESOURCE_POPULATION,
        RESOURCE_WORKERS,
        RESOURCE_RICHMEN,
        RESOURCE_ACADEMICS,
        RESOURCE_PRODUCTIONPOINTS,
        RESOURCE_EDUCATIONPOINTS
    )
}
