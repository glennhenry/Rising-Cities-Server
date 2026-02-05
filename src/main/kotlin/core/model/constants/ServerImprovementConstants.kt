package core.model.constants

object ServerImprovementConstants {
    const val IMPROVEMENT: String = "IMPROVEMENT"
    const val QUALITY_COMMON: String = "COMMON"
    const val QUALITY_RARE: String = "RARE"
    const val QUALITY_EPIC: String = "EPIC"
    const val QUALITY_LEGENDARY: String = "LEGENDARY"
    val ALL = setOf(
        IMPROVEMENT,
        QUALITY_COMMON,
        QUALITY_RARE,
        QUALITY_EPIC,
        QUALITY_LEGENDARY
    )
}
