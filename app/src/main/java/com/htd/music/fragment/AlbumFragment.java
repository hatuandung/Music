package com.htd.music.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.htd.music.R;
import com.htd.music.adapter.AlbumAdapter;
import com.htd.music.adapter.SongAdapter;
import com.htd.music.databinding.FragmentAlbumBinding;
import com.htd.music.model.Album;
import com.htd.music.model.Song;

import java.util.ArrayList;
import java.util.List;

public class AlbumFragment extends Fragment {
    private FragmentAlbumBinding binding;
    private AlbumAdapter adapter;
    private ArrayList<Album> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {


        adapter = new AlbumAdapter(getLayoutInflater());
//        binding.rvAlbum.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.rvAlbum.setAdapter(adapter);
        adapter.setAlbums(data);
        //adapter.setListener(this);

    }
    public void setData(List<Album> data) {
        this.data.clear();
        this.data.addAll(data);
        if (adapter != null) {
            adapter.setAlbums(this.data);
        }
    }
}
