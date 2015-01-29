package flickrfeed.activity

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import github.rohit.kotlintrials.R
import flickrfeed.FlickrFeedApplication
import flickrfeed.job.FetchPublicFeed

/**
 * Created by rohit.k on 1/29/2015.
 */
class FeedRandomActivity() : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flickr_feed)

        getSupportActionBar().hide()

        FlickrFeedApplication.jobMgr?.addJobInBackground(FetchPublicFeed())
    }

}