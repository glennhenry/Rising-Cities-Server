package core.model.constants

object ServerConfigElementCategory {
    const val GOOD: String = "GOOD"
    const val PLAYFIELD_ITEM_PERMISSION: String = "PLAYFIELD_ITEM_PERMISSION"
    const val RESOURCE: String = "RESOURCE"
    const val PLAYFIELD_ITEM_IMPROVEMENT: String = "PLAYFIELD_ITEM_IMPROVEMENT"
    const val PLAYFIELD_ITEM: String = "PLAYFIELD_ITEM"
    val ALL = setOf(
        GOOD,
        PLAYFIELD_ITEM_PERMISSION,
        RESOURCE,
        PLAYFIELD_ITEM_IMPROVEMENT,
        PLAYFIELD_ITEM
    )
}
