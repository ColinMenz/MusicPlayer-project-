package com.menz.titanplayer.domain;

import java.util.Comparator;

public class SongArtistComparator implements Comparator<Song> {
    
    @Override
    public int compare(Song s1, Song s2) {
        String s1Artist = s1.getArtist();
        String s2Artist = s2.getArtist();
        
        return s1Artist.compareTo(s2Artist);
    }
}
