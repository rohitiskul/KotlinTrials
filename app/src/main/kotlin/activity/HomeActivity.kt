package activity

import android.os.Bundle
import github.rohit.kotlintrials.R
import android.support.v7.widget.RecyclerView
import android.support.v7.app.ActionBarActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager

/**
 * Created by rohit.k on 1/28/2015.
 */

class HomeActivity() : ActionBarActivity() {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerList: RecyclerView = findViewById(R.id.activity_home_recycler_view) as RecyclerView

        recyclerList.setHasFixedSize(true)
        val gridLayoutMgr: GridLayoutManager = GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false)
        recyclerList.setLayoutManager(gridLayoutMgr)
        val recycleAdapter = RecyclingAdapter(createList())
        recyclerList.setAdapter(recycleAdapter)
    }

    fun createList(): Array<CardModel> {
        val obj1 = CardModel("Rkcorp", "Rkcorp blah blah blah blah blah blah")
        val obj2 = CardModel("Rohit", "Rohit blah blah blah blah blah blah")
        val obj3 = CardModel("Madhur", "Madhur blah blah blah blah blah blah")
        val obj4 = CardModel("Counter-strike", "Counter-strike blah blah blah blah blah blah")
        val obj5 = CardModel("Terrorists", "Terrorists blah blah blah blah blah blah")
        val objList = array(obj1, obj2, obj3, obj4, obj5)
        return objList
    }
}