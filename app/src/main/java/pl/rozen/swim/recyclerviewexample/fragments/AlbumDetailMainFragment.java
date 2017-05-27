package pl.rozen.swim.recyclerviewexample.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.rozen.swim.recyclerviewexample.R;
import pl.rozen.swim.recyclerviewexample.activities.AlbumDetailsActivity;
import pl.rozen.swim.recyclerviewexample.domain.Album;


public class AlbumDetailMainFragment extends Fragment {

    private Album album;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_detail_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.album = ((AlbumDetailsActivity) getActivity()).getAlbum();
    }
}
