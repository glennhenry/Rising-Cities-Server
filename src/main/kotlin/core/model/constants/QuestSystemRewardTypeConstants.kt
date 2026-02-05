package core.model.constants

object QuestSystemRewardTypeConstants {
    const val RESOURCE: String = "RESOURCE"
    const val GOOD: String = "GOOD"
    const val QUEST: String = "QUEST"
    const val PERMISSION: String = "PLAYFIELD_ITEM_PERMISSION"
    const val IMPROVEMENT: String = "PLAYFIELD_ITEM_IMPROVEMENT"
    const val ASSIST: String = "ASSIST"
    val ALL = setOf(
        RESOURCE,
        GOOD,
        QUEST,
        PERMISSION,
        IMPROVEMENT,
        ASSIST
    )
}
