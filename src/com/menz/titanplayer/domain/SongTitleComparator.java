package com.menz.titanplayer.domain;

import java.util.Comparator;

public class SongTitleComparator implements Comparator<Song> {
    
    @Override
    public int compare(Song s1, Song s2) {
        String s1Title = s1.getTitle();
        String s2Title = s2.getTitle();
        
        return s1Title.compareTo(s2Title);
    }
}
