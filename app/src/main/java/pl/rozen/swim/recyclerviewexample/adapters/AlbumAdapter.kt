package pl.rozen.swim.recyclerviewexample.adapters

import android.animation.Animator
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import pl.rozen.swim.recyclerviewexample.R
import pl.rozen.swim.recyclerviewexample.domain.Album
import org.jetbrains.anko.imageResource
import kotlinx.android.synthetic.main.album_list_row_even.view.*
import kotlinx.android.synthetic.main.album_list_row_odd.view.*

class AlbumsAdapter(private val albumsList: MutableList<Album>,
                    private val itemClick: (Album) -> Unit) :
        RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    override fun getItemCount() = albumsList.size

    override fun getItemViewType(position: Int) = position % 2

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) = holder.bindAlbum(albumsList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        when (viewType) {
            0 -> {
//                val itemView = parent.inflate(R.layout.album_list_row_even)
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.album_list_row_even, parent, false)
                return AlbumViewHolderEven(itemView, itemClick)
            }
            else -> {
//                val itemView = parent.inflate(R.layout.album_list_row_odd)
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.album_list_row_odd, parent, false)

                return AlbumViewHolderOdd(itemView, itemClick)
            }
        }
    }

    abstract class AlbumViewHolder(itemView: View, val heardIcon: ImageView, val itemClick: (Album) -> Unit) : RecyclerView.ViewHolder(itemView) {
        open fun bindAlbum(album: Album) {
            heardIconUpdate(album.heard)
            itemView.setOnClickListener { itemClick(album) }
            itemView.setOnLongClickListener {
                flipAlbum(album)
                true
            }
        }

        protected fun bindViews(album: Album, posterBackground: ImageView, poster: ImageView, title: TextView, genre: TextView, year: TextView, heardIcon: ImageView) = with(album) {
            //            TODO
//            posterBackground.imageResource = posterId

//            Picasso.with(posterBackground.context).load(posterId).fit().centerCrop()
//                    .transform(BlurTransformation(posterBackground.context, 8)).into(posterBackground)
            poster.imageResource = posterId
            title.text = this.title
            genre.text = this.genre
            year.text = this.year
            heardIcon.setOnClickListener {
                flipAlbum(this)
            }
        }

        protected fun heardIconUpdate(heard: Boolean) {
            heardIcon.imageResource = if (heard) R.drawable.ic_album_heard_layer else R.drawable.ic_album_unheard_layer
        }

        protected fun flipAlbum(album: Album) {
            album.heard = !album.heard
//            heardIcon.rotationY = 0f
//            val duration: Long = 120
//            heardIcon.animate().rotationY(90f).setDuration(duration).setListener(object : SimpleAnimatorListener() {
//                override fun onAnimationEnd(animation: Animator) {
//                    heardIconUpdate(album.heard)
//                    heardIcon.rotationY = 270f
//                    heardIcon.animate().rotationY(360f).setDuration(duration).setListener(null)
//                }
//            })
        }
    }

    class AlbumViewHolderEven(itemView: View, itemClick: (Album) -> Unit) : AlbumViewHolder(itemView, itemView.heardIconEven, itemClick) {
        override fun bindAlbum(album: Album) = with(itemView) {
            super.bindAlbum(album)
            bindViews(album, posterBackgroundEven, posterEven, titleEven, genreEven, yearEven, heardIconEven)
        }
    }

    class AlbumViewHolderOdd(itemView: View, itemClick: (Album) -> Unit) : AlbumViewHolder(itemView, itemView.heardIconOdd, itemClick) {
        override fun bindAlbum(album: Album) = with(itemView) {
            super.bindAlbum(album)
            bindViews(album, posterBackgroundOdd, posterOdd, titleOdd, genreOdd, yearOdd, heardIconOdd)
        }

    }


    fun remove(viewHolder: RecyclerView.ViewHolder, recyclerView: RecyclerView) {
        val position = viewHolder.adapterPosition
        val album = albumsList[position]
        val message = recyclerView.context.getString(R.string.list_removed_movie, album.title)
        val sb = Snackbar.make(recyclerView, message, Snackbar.LENGTH_LONG)
        sb.setAction(recyclerView.context.getString(R.string.list_removed_undo), {

            albumsList.add(position, album)
            notifyItemInserted(position)
            notifyDataSetChanged()
            notifyItemRangeChanged(position, albumsList.size)

        })
        sb.show()
        albumsList.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
        notifyItemRangeChanged(position, albumsList.size)
    }

//
//    fun remove(viewHolder: RecyclerView.ViewHolder, recyclerView: RecyclerView) {
//        val position = viewHolder.adapterPosition
//        val album = albumsList[position]
//        recyclerView.snack(recyclerView.context.getString(R.string.list_removed_album, album.title)) {
//            setAction(recyclerView.context.getString(R.string.list_removed_undo), {
//                albumsList.add(position, album)
//                notifyItemInserted(position)
//                notifyItemRangeChanged(position, albumsList.size)
//            })
//        }
//        albumsList.removeAt(position)
//        notifyItemRemoved(position)
//        notifyItemRangeChanged(position, albumsList.size)
//    }
}