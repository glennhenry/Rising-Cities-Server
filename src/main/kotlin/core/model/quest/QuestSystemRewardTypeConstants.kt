package core.model.quest

object QuestSystemRewardTypeConstants {
    const val RESOURCE = "RESOURCE"
    const val GOOD = "GOOD"
    const val QUEST = "QUEST"
    const val PLAYFIELD_ITEM_PERMISSION = "PLAYFIELD_ITEM_PERMISSION"
    const val PLAYFIELD_ITEM_IMPROVEMENT = "PLAYFIELD_ITEM_IMPROVEMENT"
    const val ASSIST = "ASSIST"
    val ALL = setOf(
        RESOURCE,
        GOOD,
        QUEST,
        PLAYFIELD_ITEM_PERMISSION,
        PLAYFIELD_ITEM_IMPROVEMENT,
        ASSIST
    )
}
