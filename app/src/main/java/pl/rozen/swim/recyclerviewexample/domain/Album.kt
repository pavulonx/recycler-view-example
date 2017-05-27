package pl.rozen.swim.recyclerviewexample.domain

import android.support.annotation.DrawableRes
import pl.rozen.swim.recyclerviewexample.R

class Album(val title: String = "",
            val author: String = "",
            val genre: String = "",
            val year: String = "",
            val description: String = "",
            val trackList: List<Track> = ArrayList(),
            @DrawableRes val posterId: Int = UNDEFINED_POSTER_IMAGE,
            val imagesIds: List<Int> = ArrayList(),
            var heard: Boolean = false,
            var rating: Float = 0.0f) {

    override fun toString(): String {
        return "Album(title='$title', author='$author', genre='$genre', year='$year')"
    }

    companion object {
        val UNDEFINED_POSTER_IMAGE: Int = R.drawable.undefined_album_poster
    }
}

class Track(val title: String = "",
            val name: String = "",
            @DrawableRes val photoId: Int = UNDEFINED_TRACK_IMAGE) {

    override fun toString(): String {
        return "Track(title='$title', name='$name', photoId=$photoId)"
    }

    companion object {
        val UNDEFINED_TRACK_IMAGE: Int = R.drawable.undefined_track_image
    }
}