package pl.rozen.swim.recyclerviewexample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_album_detail_main.*
import org.jetbrains.anko.imageResource


import pl.rozen.swim.recyclerviewexample.R
import pl.rozen.swim.recyclerviewexample.activities.AlbumDetailsActivity
import pl.rozen.swim.recyclerviewexample.domain.Album


class AlbumDetailMainFragment : Fragment() {

    private lateinit var album: Album

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_album_detail_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.album = (activity as AlbumDetailsActivity).album
        description_text_view.text = this.album.description
        album_author_text_view.text = this.album.author
        album_title_text_view.text = this.album.title
        album_detail_rating_bar.rating = this.album.rating
        poster_album_detail_image_view.imageResource = this.album.posterId
    }
}
