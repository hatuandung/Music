package com.htd.music;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.os.Bundle;
import android.provider.Settings;

import com.google.android.material.tabs.TabLayout;
import com.htd.music.adapter.SongPagerAdapter;
import com.htd.music.databinding.ActivityMainBinding;
import com.htd.music.fragment.AlbumFragment;
import com.htd.music.fragment.ArtistFragment;
import com.htd.music.fragment.SongFragment;
import com.htd.music.model.Song;
import com.htd.music.ultis.PermissionUtils;

import java.util.ArrayList;

import static com.htd.music.ultis.PermissionUtils.checkPermissions;
import static com.htd.music.ultis.PermissionUtils.requestPermissons;

public class MainActivity extends AppCompatActivity {
    private String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };
    private SystemData data;
    private ArrayList<Song> songs;
    private ActivityMainBinding binding;
    private SongPagerAdapter adapter;
    private ViewPager pager;
    private TabLayout tab;

    private SongFragment fmSong = new SongFragment();
    private AlbumFragment fmAlbum = new AlbumFragment();
    private ArtistFragment fmArtist = new ArtistFragment();

    public ViewPager getPager() {
        return pager;
    }

    public SongFragment getFmSong() {
        return fmSong;
    }

    public AlbumFragment getFmAlbum() {
        return fmAlbum;
    }

    public ArtistFragment getFmArtist() {
        return fmArtist;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        if (checkPermissions(this, PERMISSIONS)) {
            initViews();
        } else {
            requestPermissons(this, PERMISSIONS, 0);
        }
    }

    private void initViews() {
        binding.tab.setupWithViewPager(binding.pager);
        adapter = new SongPagerAdapter(getSupportFragmentManager(), fmSong, fmAlbum, fmArtist);
        binding.pager.setAdapter(adapter);

        data = new SystemData(this);
        fmSong.setData(data.getSong());
        fmAlbum.setData(data.getAlbum());
        fmArtist.setData(data.getArtist());
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermissions(this, permissions)) {
            initViews();
        } else {
            requestPermissons(this, PERMISSIONS, 0);
        }
    }

}