package core.model.constants

object ServerPaymentPackConst {
    const val INTERNAL: String = "INTERNAL"
    const val STARTERPACK: String = "STARTER"
    const val STARTERPACK2: String = "STARTER2"
    const val AID_PACK: String = "AID"
    const val PREMIUMPACK_A: String = "PREMIUM_A"
    const val EVOUCHER: String = "EVOUCHER"
    const val CINEMA: String = "CINEMA"
    const val CURRENCY: String = "CURRENCY"
    const val UPSELL: String = "UPSELL"
    const val REACTIVATION: String = "REACTIVATION"
    const val NON_PAY: String = "NON_PAY"
    const val NEW_NON_PAY: String = "NEW_NON_PAY"
    const val EXPANSION_REFUND: String = "EXPANSION_REFUND"
    const val EXTERNAL: String = "EXTERNAL"
    val ALL = setOf(
        INTERNAL,
        STARTERPACK,
        STARTERPACK2,
        AID_PACK,
        PREMIUMPACK_A,
        EVOUCHER,
        CINEMA,
        CURRENCY,
        UPSELL,
        REACTIVATION,
        NON_PAY,
        NEW_NON_PAY,
        EXPANSION_REFUND,
        EXTERNAL
    )
}
