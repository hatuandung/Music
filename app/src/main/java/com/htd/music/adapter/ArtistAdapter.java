package com.htd.music.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.htd.music.databinding.ItemArtistBinding;
import com.htd.music.model.Artist;

import java.util.ArrayList;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistHolder>{

    private LayoutInflater inflater;
    private ArrayList<Artist> artists;

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public ArtistAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ArtistAdapter.ArtistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemArtistBinding binding = ItemArtistBinding.inflate(inflater, parent, false);
        return new ArtistHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapter.ArtistHolder holder, int position) {
        holder.binding.setItem(artists.get(position));
    }

    @Override
    public int getItemCount() {
        return artists == null ? 0 : artists.size();
    }

    public class ArtistHolder extends RecyclerView.ViewHolder{
        ItemArtistBinding binding;
        public ArtistHolder(@NonNull ItemArtistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
