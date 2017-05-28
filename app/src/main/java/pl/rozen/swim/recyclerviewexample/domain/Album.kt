package pl.rozen.swim.recyclerviewexample.domain

import android.support.annotation.DrawableRes
import pl.rozen.swim.recyclerviewexample.R

class Album(val title: String = "",
            val artist: String = "",
            val genre: String = "",
            val year: String = "",
            val description: String = "",
            val artistsList: List<Artist> = ArrayList(),
            @DrawableRes val coverID: Int = UNDEFINED_POSTER_IMAGE,
            val imagesIds: List<Int> = ArrayList(),
            var heard: Boolean = false,
            var rating: Float = 0.0f) {

    override fun toString(): String {
        return "Album(title='$title', artist='$artist', genre='$genre', year='$year')"
    }

    companion object {
        val UNDEFINED_POSTER_IMAGE: Int = R.drawable.undefined_album_poster
        val UNDEFINED_ALBUM_IMAGE: Int = R.drawable.undefined_album_image
    }
}

class Artist(val name: String = "",
             @DrawableRes val photoId: Int = UNDEFINED_ARTIST_IMAGE) {

    override fun toString(): String {
        return "Artist(ame='$name', photoId=$photoId)"
    }

    companion object {
        val UNDEFINED_ARTIST_IMAGE: Int = R.drawable.undefined_person_image
    }
}