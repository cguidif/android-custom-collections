package cu.challenges.jesus.shopifychallenge.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import cu.challenges.jesus.shopifychallenge.domain.CollectionWrapper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import java.text.DateFormat
import java.util.concurrent.TimeUnit
import kotlin.math.min
import android.app.Activity
import android.util.Log
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.common.GooglePlayServicesUtil
import com.google.android.gms.security.ProviderInstaller
import cu.challenges.jesus.shopifychallenge.domain.CollectsWrapper
import cu.challenges.jesus.shopifychallenge.domain.ProductWrapper
import java.lang.StringBuilder
import kotlin.math.max

const val ClientRequestTimeout = 10L
const val CustomCollectionEndPoint = "https://shopicruit.myshopify.com/admin/custom_collections.json?page=%d&access_token=%s"
const val CollectsEndPoint = "https://shopicruit.myshopify.com/admin/collects.json?collection_id=%d&page=%d&access_token=%s"
const val ProductsEndPoint = "https://shopicruit.myshopify.com/admin/products.json?ids=%s&page=%d&access_token=%s"
const val CustomCollectionPageStart = 1
const val AccessToken = "c32313df0d0ef512ca64d5b336a0d7c6"

fun createClient() : OkHttpClient
    = OkHttpClient.Builder()
        .connectTimeout(ClientRequestTimeout, TimeUnit.SECONDS)
        .writeTimeout(ClientRequestTimeout, TimeUnit.SECONDS)
        .readTimeout(ClientRequestTimeout, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()


fun createJsonObject() : Gson
        = GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create()

inline fun <reified T> getFromJsonEndpoint(endpoint : String, vararg args : Any) : T? {
    val client = createClient()

    val url = String.format(endpoint, *args)
    val request = Request.Builder()
            .url(url)
            .build()

    var body : ResponseBody? = null
    try {
        val response = client.newCall(request).execute()
        if(response.isSuccessful){
            body = response.body()
        }
    }
    catch (t : Throwable) {
        t.printStackTrace()
    }

    if (body == null) return null


    val wrapper = createJsonObject().fromJson<T>(body.charStream(),
            T::class.java)

    return wrapper
}

fun getCollectionsResponse(page : Int?) : CollectionWrapper? {
    var _page = page ?: CustomCollectionPageStart
    _page = max(_page, CustomCollectionPageStart)

    return getFromJsonEndpoint(CustomCollectionEndPoint, _page, AccessToken)
}

fun getCollects(id : Long, page : Int?) : CollectsWrapper? {
    var _page = page ?: CustomCollectionPageStart
    _page = max(_page, CustomCollectionPageStart)

    return getFromJsonEndpoint(CollectsEndPoint, id, _page, AccessToken)
}

fun getProducts(id : Long, page : Int?) : ProductWrapper? {
    var _page = page ?: CustomCollectionPageStart
    _page = max(_page, CustomCollectionPageStart)

    val list = StringBuilder()
    var cPage = CustomCollectionPageStart
    do {
        val result = getCollects(id, cPage) ?: break
        if(result.collects.isEmpty()) break

        result.collects.forEach {
            list.append(it.product_id)
            list.append(",")
        }

        cPage++
    } while (true)

    if(list.last() == ',') list.removeRange(list.length-1, list.length-1)

    return getFromJsonEndpoint(ProductsEndPoint, list.toString(), _page, AccessToken)
}

fun updateAndroidSecurityProvider(callingActivity: Activity) {
    try {
        ProviderInstaller.installIfNeeded(callingActivity)
    } catch (e: GooglePlayServicesRepairableException) {
        // Thrown when Google Play Services is not installed, up-to-date, or enabled
        // Show dialog to allow users to install, update, or otherwise enable Google Play services.
        GooglePlayServicesUtil.getErrorDialog(e.getConnectionStatusCode(), callingActivity, 0)
    } catch (e: GooglePlayServicesNotAvailableException) {
        Log.e("SecurityException", "Google Play Services not available.")
    }

}
