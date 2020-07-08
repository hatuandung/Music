package com.htd.music.fragment;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.htd.music.R;
import com.htd.music.adapter.SongAdapter;
import com.htd.music.databinding.FragmentSongBinding;
import com.htd.music.model.Song;
import com.htd.music.ultis.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

public class SongFragment extends Fragment implements SongAdapter.SongItemClickListener {

    private static final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private FragmentSongBinding binding;
    private SongAdapter adapter;
    private ArrayList<Song> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_song, container, false);
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {


            adapter = new SongAdapter(getLayoutInflater());
            binding.rvSong.setAdapter(adapter);
            adapter.setSongs(data);
            adapter.setListener(this);

    }

    public void setData(List<Song> data) {
        this.data.clear();
        this.data.addAll(data);
        if (adapter != null) {
            adapter.setSongs(this.data);
        }
    }


    @Override
    public void onSongItemClick(Song item) {

    }


}



