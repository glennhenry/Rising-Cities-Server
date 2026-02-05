package core.model.constants

object ServerOutputConstants {
    const val RESOURCE: String = "RESOURCE"
    const val GOOD: String = "GOOD"
    const val PERMISSION: String = "PLAYFIELD_ITEM_PERMISSION"
    const val TAG: String = "TAG"
    const val ASSIST: String = "ASSIST"
    const val IMPROVEMENT: String = "PLAYFIELD_ITEM_IMPROVEMENT"
    const val BEHAVIOUR_TYPE: String = "BEHAVIOUR_TYPE"
    const val PLAYFIELD_ITEM: String = "PLAYFIELD_ITEM"
    val ALL = setOf(
        RESOURCE,
        GOOD,
        PERMISSION,
        TAG,
        ASSIST,
        IMPROVEMENT,
        BEHAVIOUR_TYPE,
        PLAYFIELD_ITEM
    )
}
