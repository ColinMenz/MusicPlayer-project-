package com.menz.titanplayer.domain;

import com.menz.titanplayer.ui.PlayerUI;
import java.io.*;
import java.util.ArrayList;

public class Player {
    
    private Library playerLibrary;
    private Playlist workingPlaylist;
    private Song workingSong;
    private ArrayList<Playlist> playlistCollection;

    
    public Player(PlayerUI frontEnd) {
        playerLibrary = new Library(frontEnd);
        workingPlaylist = new Playlist(frontEnd);
        playlistCollection = new ArrayList<>();
    }
    
    public Song getWorkingSong() {
        return workingSong;
    }
   
    public void setWorkingSong(int songIndex) {
        String length;
        workingSong = workingPlaylist.getSongByIndex(songIndex);
        initilizeMediaPlayer();
        
    }
    
    public void addPlaylistToCollection(String playlistName) {
        workingPlaylist.setPlaylistName(playlistName);
        playlistCollection.add(workingPlaylist);
        updateFrontEndList();
    }
    
    private void updateFrontEndList() {
        int selected = frontEnd.getLstPlaylistCollectionSelectedIndex();
        frontEnd.getPlaylistCollectionListData().clear();
        for (Playlist each: playlistCollection){
            frontEnd.getPlaylistCollectionListData().addElement(each.getPlaylistName());
        }
        frontEnd.setPlaylistCollectionSelection(selected);
    }
    
    public Playlist getWorkingPlaylist() {
        return workingPlaylist;
    }
    
    public Library getLibrary() {
        return playerLibrary;
    }
    
    public MediaPlayer.Status getMediaControllerStatus() {
        return mediaController.getStatus();
    }
    
    public void setWorkingPlaylist(Playlist playlistToAdd) {
        workingPlaylist = playlistToAdd;
        updateFrontEndList();
    }
    
    public void loadSavedPlaylist(int index) {
        setWorkingPlaylist(playlistCollection.get(index));
    }
    
    public void loadNextSongFromList () {
        if (workingPlaylist.songCount() > 0) {
            workingSong = workingPlaylist.nextSongInList();
            initilizeMediaPlayer();
            frontEnd.setPlaylistSelection(workingPlaylist.getPosition());
        } else {
            JOptionPane.showMessageDialog(null, "You must add at least one item to the Playlist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public void loadPreviousSongFromList () {
        if (workingPlaylist.songCount() > 0) {
            workingSong = workingPlaylist.previousSongInList();
            initilizeMediaPlayer();
            frontEnd.setPlaylistSelection(workingPlaylist.getPosition());
        } else {
            JOptionPane.showMessageDialog(null, "You must add at least one item to the Playlist.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void initilizeMediaPlayer() {
        boolean playing = false;
        if (mediaController != null && mediaController.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaController.stop();
            playing = true;
        }
        if (playing) {
            playWorkingSong();
        }
    }

    public void playWorkingSong() {
        if (workingSong != null) {
            mediaController.play();
        } else if (workingPlaylist.songCount() > 0) {
            setWorkingSong(0);
            frontEnd.setPlaylistSelection(0);
        } else {
            JOptionPane.showMessageDialog(null, "You must add at least one item to the Playlist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void stopWorkingSong() {
        if (workingSong != null) {
            mediaController.stop();
        }
    }
    
    public void pauseWorkingSong() {
        if (workingSong != null) {
            mediaController.pause();
        }
    }
    
}
