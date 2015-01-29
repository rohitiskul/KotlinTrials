package recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import android.view.LayoutInflater
import github.rohit.kotlintrials.R

/**
 * Created by rohit.k on 1/28/2015.
 */
class RecyclingAdapter(cardList: Array<CardModel>) : RecyclerView.Adapter<CardModelHolder>() {

    val cardList: Array<CardModel> = cardList;

    override fun onBindViewHolder(viewHolder: CardModelHolder?, position: Int) {
        val cardModel: CardModel = cardList.get(position)
        viewHolder?.headerTextView?.setText(cardModel.header)
        viewHolder?.descTextView?.setText(cardModel.description)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup?, position: Int): CardModelHolder? {
        val itemView: View = LayoutInflater.from(viewGroup?.getContext()).inflate(R.layout.item_card, viewGroup, false)
        return CardModelHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cardList.size()
    }

}