package pl.rozen.swim.recyclerviewexample.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import pl.rozen.swim.recyclerviewexample.domain.Album
import pl.rozen.swim.recyclerviewexample.R
import pl.rozen.swim.recyclerviewexample.adapters.AlbumsAdapter
import pl.rozen.swim.recyclerviewexample.listeners.RecyclerTouchListener
import android.widget.Toast
import android.view.View
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var mAdapter:AlbumsAdapter
    private val albumList = ArrayList<Album>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        mAdapter = AlbumsAdapter(albumList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, mLayoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.adapter = mAdapter


        recyclerView.addOnItemTouchListener(RecyclerTouchListener(
                applicationContext, recyclerView, object : RecyclerTouchListener.ClickListener {
            override fun onClick(view: View, position: Int) {
                val album = albumList[position]
                Toast.makeText(applicationContext, album.title + " is selected!", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(view: View, position: Int) {
            }
        }))

        prepareMovieData()

    }
    private fun prepareMovieData() {
        val movies = arrayListOf(
                Album("Got Your Six", "Five Finger Death Punch", "heavy metal", "2015"),
                Album("The Wrong Side of Heaven and the Righteous Side of Hell, Volume 1",
                        "Five Finger Death Punch", "heavy metal", "2013"),
                Album("The Wrong Side of Heaven and the Righteous Side of Hell, Volume 2",
                        "Five Finger Death Punch", "heavy metal", "2013"),
                Album("American Capitalist", "Five Finger Death Punch","heavy metal", "2011"),
                Album("Nightmare", "Avenged Sevenfold", "heavy metal", "2010"),
                Album("Hail to the King", "Avenged Sevenfold", "heavy metal", "2013"),
                Album("The Stage","Avenged Sevenfold", "heavy metal", "2016"),
                Album("Avenged Sevenfold","Avenged Sevenfold", "heavy metal", "2017"),
                Album("Seal the Deal & Let's Boogie", "Volbeat", "alternative metal, heavy metal", "2016"),
                Album("Outlaw Gentlemen & Shady Ladies", "Volbeat", "alternative metal, heavy metal", "2013"),
                Album("Beyond Hell / Above Heaven", "Volbeat", "heavy metal", "2010"),
                Album("Guitar Gangsters & Cadillac Blood", "Volbeat", "alternative metal", "2008"),
                Album("Rock the Rebel / Metal the Devil", "Volbeat", "heavy metal", "2007"),
                Album("The Strength / The Sound / The Songs", "Volbeat", "heavy metal", "2005")
        )
        albumList.addAll(movies)
        mAdapter.notifyDataSetChanged()
    }
}
