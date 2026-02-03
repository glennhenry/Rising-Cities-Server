package core.data

import kotlinx.serialization.Serializable

@Serializable
data class FlashVars(
    val policyPort: Int = 7777,
    val marketMaintenance: Boolean = false,
    val pmsMaintenance: Boolean = false,
    val newsscreenGfxId: String = "0",
    val newsscreenLocaleId: String = "0",
    val isChrome: Boolean = false,
    val keepAliveUrl: String? = null,
    val connectionUrl: String = "http://127.0.0.1:7777",
    val path: String = "",
    val uid: Long = 1L,
    val lang: String = "en",
    val sid: String = "",
    val supportUrl: String = "",
    val logoutUrl: String = "",
    val profileUrl: String = "",
    val forumUrl: String = "",
    val paymentUrl: String = "",
    val cvtagfilepath: String = "xml/cvFileLinks.xml",
    val debugMode: Boolean = true,
    val debugLayerUrl: String = "http://127.0.0.1:8080/debug",
    val cvtagruntimepath: String = "xml/cvRuntimeLinks.xml",
    val isIE: Boolean = false,
    val isSsoUser: Boolean = false,
    val evoucherUrl: String = "",
    val unreadMessages: Boolean = false,
    val soldOffers: Boolean = false,
    val buffLevel: Int = 6,
    val marketLevel: Int = 5,
    val newsscreenLinkType: String = "",
    val newsscreenLinkValue: String = "",
    val improvmentLevel: Int = 7,
    val boosterStoreLevel: Int = 7,
    val cinemaMaintenance: Boolean = false,
    val cinemaDisabled: Boolean = false,
    val upsell: Boolean = false,
    val inviteDisabled: Boolean = false,
    val projectId: Int = 865,
    val eventStream: String = "eyJ1aWQiOjF9"
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
