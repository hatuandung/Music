package com.htd.music.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.htd.music.databinding.ItemSongBinding;
import com.htd.music.model.Song;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {
    private LayoutInflater inflater;
    private ArrayList<Song> songs;
    private SongItemClickListener listener;

    public SongAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setListener(SongItemClickListener listener) {
        this.listener = listener;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSongBinding binding = ItemSongBinding.inflate(inflater, parent, false);
        return new SongHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, int position) {
        holder.binding.setItem(songs.get(position));
        if (listener!= null){
            holder.binding.setListener(listener);
        }
    }

    @Override
    public int getItemCount() {
        return songs == null ? 0 : songs.size();
    }


    public class SongHolder extends RecyclerView.ViewHolder {
        private ItemSongBinding binding;

        public SongHolder(@NonNull ItemSongBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface SongItemClickListener {
        void onSongItemClick(Song item);
    }
}
