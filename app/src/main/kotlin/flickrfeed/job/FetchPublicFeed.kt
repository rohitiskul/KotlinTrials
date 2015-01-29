package flickrfeed.job

import com.path.android.jobqueue.Job
import com.path.android.jobqueue.Params
import flickrfeed.http.HttpClient
import flickrfeed.parser.XmlParser

/**
 * Created by rohit.k on 1/29/2015.
 */
class FetchPublicFeed() : Job(Params(1000).requireNetwork()) {
    override fun onAdded() {
    }

    override fun onRun() {
        val xmlData: String = HttpClient().loadUrl("https://api.flickr.com/services/feeds/photos_public.gne")
        XmlParser(xmlData).parse()
    }

    override fun onCancel() {
    }

    override fun shouldReRunOnThrowable(throwable: Throwable?): Boolean {
        return false
    }

}