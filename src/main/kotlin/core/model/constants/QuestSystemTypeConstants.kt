package core.model.constants

object QuestSystemTypeConstants {
    const val TUTORIAL: String = "TUTORIAL"
    const val SCREEN: String = "SCREEN"
    const val SOCIAL: String = "SOCIAL"
    const val CLICK: String = "CLICK"
    const val EVENT: String = "EVENT"
    const val CHALLENGE: String = "CHALLENGE"
    const val TASK: String = "TASK"
    const val RESOURCE_PLAYER: String = "RESOURCE_PLAYER"
    const val SUB_TYPE_DEPOSIT_GOOD: String = "CONSUME_GOOD"
    const val SUB_TYPE_DEPOSIT_RESOURCE: String = "CONSUME_RESOURCE"
    val ALL = setOf(
        TUTORIAL,
        SCREEN,
        SOCIAL,
        CLICK,
        EVENT,
        CHALLENGE,
        TASK,
        RESOURCE_PLAYER,
        SUB_TYPE_DEPOSIT_GOOD,
        SUB_TYPE_DEPOSIT_RESOURCE
    )
}
