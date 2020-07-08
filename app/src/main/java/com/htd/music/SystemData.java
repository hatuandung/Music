package com.htd.music;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.htd.music.model.Album;
import com.htd.music.model.Artist;
import com.htd.music.model.Song;

import java.util.ArrayList;

public class SystemData {

    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();
    }

    public ArrayList<Song> getSong() {
        ArrayList<Song> arr = new ArrayList<>();

        //ContactsContract.Contacts.CONTENT_URI
        //Telephony.Sms.CONTENT_URI
        //CallLog.CONTENT_URI
//        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
//        MediaStore.Audio.Media.INTERNAL_CONTENT_URI
        Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null);
        cursor.moveToFirst();


        int indexId = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM_ID);
        int indexData = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
        int indexSize = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE);
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);


        while (cursor.isAfterLast() == false) {
            long id = cursor.getLong(indexId);
            String data = cursor.getString(indexData);
            int size = cursor.getInt(indexSize);
            int duration = cursor.getInt(indexDuration);
            String title = cursor.getString(indexTitle);
            String artist = cursor.getString(indexArtist);
            String album = cursor.getString(indexAlbum);

            Song song = new Song();
            song.setId(id);
            song.setAlbum(album);
            song.setArtist(artist);
            song.setData(data);
            song.setDuration(duration);
            song.setSize(size);
            song.setTitle(title);
            arr.add(song);
            cursor.moveToNext();
        }
        cursor.close();
        return arr;
    }

    public ArrayList<Album> getAlbum(){
        ArrayList<Album> arr = new ArrayList<>();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                null, null, null, null
        );
        cursor.moveToFirst();

        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST);
        int indexNumberOfSong = cursor.getColumnIndex(MediaStore.Audio.Albums.NUMBER_OF_SONGS);
        int indexImage = cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ID);

        while (cursor.isAfterLast() == false) {
            Album album = new Album();

            //album.setImage(cursor.getLong(indexImage));
            album.setAlbum(cursor.getString(indexAlbum));
            album.setArtist(cursor.getString(indexArtist));
            album.setNumberOfSong(cursor.getString(indexNumberOfSong));

            arr.add(album);
            cursor.moveToNext();
        }
        return arr;
    }

    public ArrayList<Artist> getArtist() {
        ArrayList<Artist> arr = new ArrayList<>();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                null, null, null, null
        );
        cursor.moveToFirst();

        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST);
        int indexNumberOfAlbums = cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_ALBUMS);
        int indexNumberOfTracks = cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_TRACKS);

        while (cursor.isAfterLast() == false) {
            Artist artist = new Artist();

            artist.setArtist(cursor.getString(indexAlbum));
            artist.setNumberOfAlbum(cursor.getString(indexNumberOfAlbums));
            artist.setNumberOfSong(cursor.getString(indexNumberOfTracks));

            arr.add(artist);
            cursor.moveToNext();
        }
        return arr;
    }
}
