package recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import github.rohit.kotlintrials.R
import android.widget.TextView

/**
 * Created by rohit.k on 1/28/2015.
 */
class CardModelHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    public val headerTextView: TextView = itemView.findViewById(R.id.item_card_header) as TextView
    public val descTextView: TextView = itemView.findViewById(R.id.item_card_desc) as TextView
}