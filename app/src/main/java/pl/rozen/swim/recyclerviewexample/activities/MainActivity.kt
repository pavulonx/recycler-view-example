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
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var mAdapter:AlbumsAdapter
    private val albumList = LinkedList<Album>()

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
        prepareMovieData()

    }
    private fun prepareMovieData() {
        val movies = arrayListOf(
                Album("Got Your Six", "Five Finger Death Punch", "heavy metal", "2015"),
                Album("The Wrong Side of Heaven and the Righteous Side of Hell, Volume 1 I jeszcze dłuższy text",
                        "Five Finger Death Punch", "heavy metal", "2013"),
                Album("The Wrong Side of Heaven and the Righteous Side of Hell, Volume 2",
                        "Five Finger Death Punch", "heavy metal", "2013"),
                Album("American Capitalist", "Five Finger Death Punch","heavy metal", "2011"),
                Album("Some Title", "The Martian", "Science Fiction & Fantasy", "2015"),
                Album("Some Title", "Mission: Impossible Rogue Nation", "Action", "2015"),
                Album("Some Title", "Up", "Animation", "2009"),
                Album("Some Title", "Star Trek", "Science Fiction", "2009"),
                Album("Some Title", "The LEGO Movie", "Animation", "2014"),
                Album("Some Title", "Iron Man", "Action & Adventure", "2008"),
                Album("Some Title", "Aliens", "Science Fiction", "1986"),
                Album("Some Title", "Chicken Run", "Animation", "2000"),
                Album("Some Title", "Back to the Future", "Science Fiction", "1985"),
                Album("Some Title", "Raiders of the Lost Ark", "Action & Adventure", "1981"),
                Album("Some Title", "Goldfinger", "Action & Adventure", "1965"),
                Album("Some Title", "Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        )
        albumList.addAll(movies)
        mAdapter.notifyDataSetChanged()
    }
}
