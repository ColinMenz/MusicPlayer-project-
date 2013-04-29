/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menz.titanplayer.domain;

import com.menz.titanplayer.ui.PlayerUI;
import java.util.*;

public class Library {
    
    private ArrayList<Song> songs;
    private PlayerUI frontEnd;
    
    public Library(PlayerUI frontEnd) {
        this.frontEnd = frontEnd;
	songs = new ArrayList<>();
    }
    
    public Song getSongByIndex(int index) {
        return songs.get(index);
    }
    
   public int songCount() {
	return songs.size();
    }

    public void addSong(Song songToAdd) {
	songs.add(songToAdd);
        updateFrontEndList();
    }
    
    public void removeSong(Song songToRemove) {
	songs.remove(songToRemove);
        updateFrontEndList();
    }
    
    public void sortLibraryByTitle() {
        Collections.sort(songs, new SongTitleComparator());
        updateFrontEndList();
    }

    public void sortLibraryByArtist() {
        Collections.sort(songs, new SongArtistComparator());
        updateFrontEndList();
    }
    
    private void updateFrontEndList() {
        int selected = frontEnd.getLstLibrarySelectedIndex();
        frontEnd.getLibraryListData().clear();
        for (Song each: songs){
        frontEnd.getLibraryListData().addElement(each.getArtist() + " - " + each.getTitle());
        }
        if (selected < songs.size()) {
            frontEnd.setLibrarySelection(selected);
        }
   }
    
    

}
