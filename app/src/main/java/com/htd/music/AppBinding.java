package com.htd.music;

import android.net.Uri;
import android.text.format.Formatter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class AppBinding {
    @BindingAdapter("duration")
    public static void parseTime(TextView textView, int duration) {
        String str = String.format(
                "%02d:%02d",
                (duration % 3600) / 60 / 1000,
                duration / 1000 % 60);
        textView.setText(str);
    }

    @BindingAdapter("size")
    public static void parseSize(TextView tv, int size) {
        String str = Formatter.formatFileSize(tv.getContext(), size);
        tv.setText(str);
    }

    @BindingAdapter("image")
    public static void thumb(ImageView img, long id) {
        Uri uri = Uri.parse("content://media/external/audio/albumart/" + id);
        Glide.with(img).load(uri).into(img);
    }

    @BindingAdapter("albumcount")
    public static void countAlbum (TextView tv, String album){

    }
}
