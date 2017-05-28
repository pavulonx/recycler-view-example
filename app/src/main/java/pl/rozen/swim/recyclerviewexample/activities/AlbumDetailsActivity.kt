package pl.rozen.swim.recyclerviewexample.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import kotlinx.android.synthetic.main.activity_album_details.*

import pl.rozen.swim.recyclerviewexample.R
import pl.rozen.swim.recyclerviewexample.domain.Album
import pl.rozen.swim.recyclerviewexample.fragments.AlbumDetailSecondFragment
import pl.rozen.swim.recyclerviewexample.fragments.AlbumDetailMainFragment
import pl.rozen.swim.recyclerviewexample.models.DatabaseHelper

class AlbumDetailsActivity : AppCompatActivity() {

    lateinit var album:Album

    companion object {
        val NUM_PAGES = 2
        val MOVIE_INDEX = "MovieDetailsActivity:movieIndex"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        val albumIndex = intent.getIntExtra(MOVIE_INDEX, -1)
        album = DatabaseHelper.getAlbumAt(albumIndex)

//        setSupportActionBar(toolbar_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = album.title

        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        viewPagerDetails.adapter = pagerAdapter
        viewPagerDetails.setPageTransformer(true, { page: View?, position: Float -> })

    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int) = when (position) {
            0 -> AlbumDetailMainFragment()
            else -> AlbumDetailSecondFragment()
        }

        override fun getCount() = NUM_PAGES
    }

}
