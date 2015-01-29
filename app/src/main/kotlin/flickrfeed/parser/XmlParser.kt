package flickrfeed.parser

import org.xmlpull.v1.XmlPullParser
import android.util.Xml
import java.io.InputStream
import java.io.ByteArrayInputStream
import java.util.ArrayList
import android.util.Log

/**
 * Created by rohit.k on 1/29/2015.
 */
class XmlParser(xmlString: String) {

    private val xmlString: String = xmlString

    val feedList: ArrayList<String> = ArrayList()

    fun parse() {
        val xmlPullParser: XmlPullParser = Xml.newPullParser()
        xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
        val inputStream: InputStream = ByteArrayInputStream(xmlString.toByteArray("UTF-8"));
        xmlPullParser.setInput(inputStream, "UTF-8")
        var eventType: Int = xmlPullParser.getEventType()
        var tag: String
        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    tag = xmlPullParser.getName()
                    if (tag.equalsIgnoreCase("link")) {
                        val linkRel: String? = xmlPullParser.getAttributeValue(null, "rel")
                        val linkType: String? = xmlPullParser.getAttributeValue(null, "type")
                        if (linkRel != null && linkRel.equalsIgnoreCase("enclosure") && linkType != null && linkType.startsWith("image")) {
                            Log.d("Parser", "This is link tag with rel = ${linkRel} and type = ${linkType}")
                            val linkHref: String = xmlPullParser.getAttributeValue(null, "href")
                            feedList.add(linkHref)
                        }
                    }
                }
            }
            eventType = xmlPullParser.next()
        }
    }
}