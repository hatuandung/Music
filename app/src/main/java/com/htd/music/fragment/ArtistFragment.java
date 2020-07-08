package com.htd.music.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.htd.music.R;
import com.htd.music.adapter.AlbumAdapter;
import com.htd.music.adapter.ArtistAdapter;
import com.htd.music.databinding.FragmentArtistBinding;
import com.htd.music.model.Album;
import com.htd.music.model.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistFragment extends Fragment {
    private FragmentArtistBinding binding;
    private ArtistAdapter adapter;
    private ArrayList<Artist> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artist, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {


        adapter = new ArtistAdapter(getLayoutInflater());
//        binding.rvAlbum.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.rvArtist.setAdapter(adapter);
        adapter.setArtists(data);
        //adapter.setListener(this);

    }
    public void setData(List<Artist> data) {
        this.data.clear();
        this.data.addAll(data);
        if (adapter != null) {
            adapter.setArtists(this.data);
        }
    }
}
