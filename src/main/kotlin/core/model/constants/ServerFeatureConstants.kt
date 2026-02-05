package core.model.constants

object ServerFeatureConstants {
    const val FEATURE_REQUIRED_TYPE_LEVEL: String = "USER_LEVEL"
    const val FEATURE_REQUIRED_TYPE_QUEST: String = "QUEST"
    const val BIRTHDAY_EVENT_2013: String = "BIRTHDAY_EVENT_2013"
    const val CITYWHEEL: String = "CITY_WHEEL"
    const val COASTAL_PLAYFIELD_SWITCH: String = "SECOND_PLAYFIELD"
    const val SUBURBAN_PLAYFIELD_SWITCH: String = "THIRD_PLAYFIELD"
    const val MOUNTAIN_PLAYFIELD_SWITCH: String = "FOURTH_PLAYFIELD"
    const val BUILDING_MASTERY: String = "MASTERY"
    const val EMERGENCY: String = "EMERGENCY"
    const val EVENTSQUARE: String = "EVENTSQUARE"
    const val EXPANSION: String = "EXPANSION"
    val ALL = setOf(
        FEATURE_REQUIRED_TYPE_LEVEL,
        FEATURE_REQUIRED_TYPE_QUEST,
        BIRTHDAY_EVENT_2013,
        CITYWHEEL,
        COASTAL_PLAYFIELD_SWITCH,
        SUBURBAN_PLAYFIELD_SWITCH,
        MOUNTAIN_PLAYFIELD_SWITCH,
        BUILDING_MASTERY,
        EMERGENCY,
        EVENTSQUARE,
        EXPANSION
    )
}
