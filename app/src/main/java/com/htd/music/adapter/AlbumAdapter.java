package com.htd.music.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.htd.music.databinding.ItemAlbumBinding;
import com.htd.music.model.Album;
import com.htd.music.model.Song;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumHolder> {

    private LayoutInflater inflater;
    private ArrayList<Album> albums;

    public AlbumAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAlbumBinding binding = ItemAlbumBinding.inflate(inflater, parent, false);
        return new AlbumHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumHolder holder, int position) {
        holder.binding.setItem(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums == null ? 0 : albums.size();
    }

    public class AlbumHolder extends RecyclerView.ViewHolder {
        private ItemAlbumBinding binding;
        public AlbumHolder(@NonNull ItemAlbumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
