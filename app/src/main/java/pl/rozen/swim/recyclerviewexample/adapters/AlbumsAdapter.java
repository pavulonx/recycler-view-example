//package pl.rozen.swim.recyclerviewexample.adapters;
//
//import android.support.design.widget.Snackbar;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//
//import pl.rozen.swim.recyclerviewexample.R;
//import pl.rozen.swim.recyclerviewexample.domain.Album;
//
//public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {
//
//    private List<Album> albumList;
//
//    public void remove(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView recyclerView) {
//        final int position = viewHolder.getAdapterPosition();
//        final Album album = albumList.get(position);
//        String message = recyclerView.getContext().getString(R.string.list_removed_movie, album.getTitle());
//        Snackbar sb = Snackbar.make(recyclerView, message, Snackbar.LENGTH_LONG);
//        sb.setAction(recyclerView.getContext().getString(R.string.list_removed_undo), new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                albumList.add(position, album);
//                notifyItemInserted(position);
//                notifyDataSetChanged();
//            }
//        });
//        sb.show();
//        albumList.remove(position);
//        notifyItemRemoved(position);
//        notifyDataSetChanged();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextView title, author, year, genre;
//
//        public MyViewHolder(View view) {
//            super(view);
//            title = (TextView) view.findViewById(R.id.title);
//            author = (TextView) view.findViewById(R.id.author);
//            genre = (TextView) view.findViewById(R.id.genre);
//            year = (TextView) view.findViewById(R.id.year);
//        }
//    }
//
//
//    public AlbumsAdapter(List<Album> albumList) {
//        this.albumList = albumList;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.album_list_row, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Album album = albumList.get(position);
//        holder.title.setText(album.getTitle());
//        holder.author.setText(album.getAuthor());
//        holder.genre.setText(album.getGenre());
//        holder.year.setText(album.getYear());
//    }
//
//    @Override
//    public int getItemCount() {
//        return albumList.size();
//    }
//}
