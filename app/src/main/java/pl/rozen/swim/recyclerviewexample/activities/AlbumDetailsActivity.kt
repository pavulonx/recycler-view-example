package pl.rozen.swim.recyclerviewexample.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import pl.rozen.swim.recyclerviewexample.R
import pl.rozen.swim.recyclerviewexample.models.DatabaseHelper

class AlbumDetailsActivity : AppCompatActivity() {


    companion object {
        val NUM_PAGES = 2
        val MOVIE_INDEX = "MovieDetailsActivity:movieIndex"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        val albumIndex = intent.getIntExtra(MOVIE_INDEX, -1)
        val album = DatabaseHelper.getAlbumAt(albumIndex)

    }
}
