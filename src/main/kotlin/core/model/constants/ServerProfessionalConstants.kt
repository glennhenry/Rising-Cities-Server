package core.model.constants

object ServerProfessionalConstants {
    const val ROOKIE: Int = 1
    const val SPECIALIST: Int = 2
    const val HERO: Int = 3
    const val ATTRIBUTE_LUCK: String = "LUCK"
    const val ATTRIBUTE_EFFICIENCY: String = "EFFICIENCY"
    const val ATTRIBUTE_GOOFINESS: String = "GOOFINESS"
    const val ATTRIBUTE_ADAPTABILITY: String = "ADAPTABILITY"
    const val ATTRIBUTE_PERCEPTION: String = "PERCEPTION"
    const val REWARD_AMOUNT: String = "REWARD_AMOUNT"
    const val REWARD_TIER: String = "REWARD_TIER"
    const val SECURITY_RANGE: String = "SECURITY_RANGE"
    const val TRAIT_UNLOCK: String = "TRAIT_UNLOCK"
    val ALL = setOf(
        ROOKIE,
        SPECIALIST,
        HERO,
        ATTRIBUTE_LUCK,
        ATTRIBUTE_EFFICIENCY,
        ATTRIBUTE_GOOFINESS,
        ATTRIBUTE_ADAPTABILITY,
        ATTRIBUTE_PERCEPTION,
        REWARD_AMOUNT,
        REWARD_TIER,
        SECURITY_RANGE,
        TRAIT_UNLOCK
    )
}
