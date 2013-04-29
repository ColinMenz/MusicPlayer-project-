package com.menz.titanplayer.domain;

public class Song {
    
    private String artist;
    private String title;
    private String fileLocation;
    
    public Song(String title, String artist) {
        this.artist = artist;
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
}
