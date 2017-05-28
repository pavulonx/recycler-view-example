package pl.rozen.swim.recyclerviewexample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.rozen.swim.recyclerviewexample.R
import pl.rozen.swim.recyclerviewexample.activities.AlbumDetailsActivity
import pl.rozen.swim.recyclerviewexample.domain.Album

/**
 * Created by rozen on 28.05.17.
 */
class AlbumDetailSecondFragment : Fragment() {

    private lateinit var album: Album

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return LayoutInflater.from(context).inflate(R.layout.fragment_album_detail_second, container, false)
        return inflater!!.inflate(R.layout.fragment_album_detail_second, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        album = (activity as AlbumDetailsActivity).album

//        album.imagesIds.iterator()
//        for ((index, image) in album.imagesIds.withIndex()){
//            if((0..6).contains(index)){
//
//            } else
//                break
//        }
    }
}