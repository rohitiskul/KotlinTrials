package flickrfeed.http

import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response

/**
 * Created by rohit.k on 1/29/2015.
 */
class HttpClient {

    private val okClient = OkHttpClient()

    fun loadUrl(url: String): String {
        val request: Request = Request.Builder().url(url).build()
        val response: Response = okClient.newCall(request).execute()
        return response.body().string()
    }

}
