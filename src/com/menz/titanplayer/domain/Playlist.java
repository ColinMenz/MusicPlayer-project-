package com.menz.titanplayer.domain;

import com.menz.titanplayer.ui.PlayerUI;
import java.util.*;

public class Playlist {
    
    private ArrayList<Song> songs;
    private PlayerUI frontEnd;
    private String playlistName;
    private int position = -1;
    
    public Playlist(String name, PlayerUI frontEnd) {
	songs = new ArrayList<>();
        this.frontEnd = frontEnd;
	this.playlistName = name;
    }

    Playlist(PlayerUI frontEnd) {
        songs = new ArrayList<>();
        this.frontEnd = frontEnd;
    }
    
    public String getPlaylistName() {
	return playlistName;
    }
    
    public void setPlaylistName(String name) {
        playlistName = name;
    }
    
    public int getPosition() {
        return position;
    }
    
    public int songCount() {
	return songs.size();
    }
    
    public Song getSongByIndex(int index) {
        position = index;
        return songs.get(index);
    }
    
   public void addSong(Song songToAdd) {
	songs.add(songToAdd);
        updateFrontEndList();
    }
   
    public void removeSong(Song songToRemove) {
	songs.remove(songToRemove);
        updateFrontEndList();
    }
   
   public Song nextSongInList() {
       if (position == songCount() -1) {
           position = -1;
       }
       position ++;
       return songs.get(position);
   }
   
   public Song previousSongInList() {
       if (position ==  0) {
           position = songCount();
       }
       position --;
       return songs.get(position);
   }
   
   public void clearPlaylist() {
       songs = new ArrayList<>();
       frontEnd.setTxtPlaylistName("");
       updateFrontEndList();
   }
   
   private void updateFrontEndList() {
        int selected = frontEnd.getLstPlaylistSelectedIndex();
        frontEnd.getPlaylistListData().clear();
        for (Song each: songs){
        frontEnd.getPlaylistListData().addElement(each.getArtist() + " - " + each.getTitle());
        }
        if (selected < songs.size()) {
            frontEnd.setPlaylistSelection(selected);
        }
   }
    
}