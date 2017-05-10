package com.aurailus.caninemusic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends BaseAdapter {
    private ArrayList<Album> albums;
    private LayoutInflater albumInf;
    private boolean moredetails;
    private ConstraintLayout albumLay;

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int ind, View convertView, ViewGroup parent) {

        if (!moredetails) albumLay = (ConstraintLayout)albumInf.inflate(R.layout.album_grid, parent, false);
        else  albumLay = (ConstraintLayout)albumInf.inflate(R.layout.album_list, parent, false);

        TextView albumView = (TextView)albumLay.findViewById(R.id.album_title);
        TextView artistView = (TextView)albumLay.findViewById(R.id.album_artist);
        ImageView albumArtView = (ImageView) albumLay.findViewById(R.id.album_art);

        Album curAlbum = albums.get(ind);
        albumView.setText(curAlbum.getTitle());
        if (!curAlbum.getEmpty()) {
            Drawable img = curAlbum.getImage();
            albumArtView.setImageDrawable(img);
        }

        if (moredetails) {
            TextView playsView = (TextView) albumLay.findViewById(R.id.album_plays);
            TextView lengthView = (TextView) albumLay.findViewById(R.id.album_length);

            artistView.setText(curAlbum.getArtist());
            playsView.setText(" Plays");
            //lengthView.setText(curAlbum.getLength());
        }

        albumLay.setTag(curAlbum.getId());
        return albumLay;
    }

    public AlbumAdapter(Context c, ArrayList<Album> albums, boolean list) {
        this.albums = albums;
        this.moredetails = list;
        albumInf = LayoutInflater.from(c);
    }
}