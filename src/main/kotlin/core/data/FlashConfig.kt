package core.data

import kotlinx.serialization.Serializable

@Serializable
data class FlashVars(
    val uid: String = "1",
    val lang: String = "en",
    val sid: String = "sessionId123",
    val connectionUrl: String = "http://127.0.0.1:7777",
    val supportUrl: String = "http://127.0.0.1:8080/stub",
    val logoutUrl: String = "http://127.0.0.1:8080/stub",
    val profileUrl: String = "http://127.0.0.1:8080/stub",
    val forumUrl: String = "http://127.0.0.1:8080/stub",
    val paymentUrl: String = "http://127.0.0.1:8080/stub",
    val cvtagfilepath: String = "xml/cvFileLinks.xml",
    val debugMode: String = "true",
    val debugLayerUrl: String = "http://127.0.0.1:8080/debug",
    val cvtagruntimepath: String = "xml/cvRuntimeLinks.xml",
    val isIE: String = "false",
    val isSsoUser: String = "false",
    val evoucherUrl: String = "http://127.0.0.1:8080/stub",
    val unreadMessages: String = "false",
    val soldOffers: String = "false",
    val buffLevel: String = "0",
    val marketLevel: String = "0",
    val newsscreenLinkType: String = "",
    val newsscreenLinkValue: String = "",
    val improvmentLevel: String = "0",
    val boosterStoreLevel: String = "0",
    val cinemaMaintenance: String = "false",
    val cinemaDisabled: String = "false",
    val upsell: String = "false",
    val inviteDisabled: String = "false",
    val projectId: String = "0",
    val eventStream: String = ""
)

@Serializable
data class FlashParams(
    val menu: String = "true",
    val scale: String = "showAll",
    val allowFullscreen: String = "true",
    val allowFullScreenInteractive: String = "true",
    val allowScriptAccess: String = "always",
    val bgcolor: String = "#000000",
    val wmode: String = "direct"
)

@Serializable
data class FlashAttributes(
    val id: String = "Main",
    val name: String = "RisingCities",
    val align: String = "middle"
)

@Serializable
data class FlashConfig(
    val flashVars: FlashVars = FlashVars(),
    val flashParams: FlashParams = FlashParams(),
    val flashAttributes: FlashAttributes = FlashAttributes()
)
