package flickrfeed

import android.app.Application
import com.path.android.jobqueue.JobManager
import com.path.android.jobqueue.config.Configuration

/**
 * Created by rohit.k on 1/29/2015.
 */
class FlickrFeedApplication() : Application() {
    //static access member
    class object {
        public var application: FlickrFeedApplication? = null
        public var jobMgr: JobManager? = null
    }


    override fun onCreate() {
        super.onCreate()
        FlickrFeedApplication.application = this
        val config: Configuration = Configuration.Builder(this)
                .minConsumerCount(1)
                .maxConsumerCount(3)
                .loadFactor(3)
                .consumerKeepAlive(120).build()
        jobMgr = JobManager(this, config)
    }
}