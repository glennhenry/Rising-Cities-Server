package core.model.constants

object EmergencyConstants {
    const val EMERGENCY_STATUS_STARTED: String = "EMERGENCY"
    const val EMERGENCY_STATUS_SUCCESS: String = "REWARD"
    const val EMERGENCY_STATUS_FAIL: String = "DAMAGED"
    const val EMERGENCY_INPROGRESS: String = "PROGRESS"
    val ALL = setOf(
        EMERGENCY_STATUS_STARTED,
        EMERGENCY_STATUS_SUCCESS,
        EMERGENCY_STATUS_FAIL,
        EMERGENCY_INPROGRESS
    )
}
