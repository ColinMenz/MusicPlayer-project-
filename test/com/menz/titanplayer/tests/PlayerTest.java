package com.menz.titanplayer.tests;

import com.menz.titanplayer.domain.Song;
import com.menz.titanplayer.domain.Player;
import com.menz.titanplayer.domain.Playlist;
import com.menz.titanplayer.ui.PlayerUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javafx.scene.media.*;

public class PlayerTest {
    
        Playlist testPlaylist;
        Player testPlayer;
        Song song1 = new Song("Dont You Worry Child", "Swedish House Mafia");
        Song song2 = new Song("Kickstart My Heart", "Motley Crue");
        Song song3 = new Song("Taken Care of Business", "BTO");

    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testPlaylist = new Playlist("Test Playlist", new PlayerUI());
        testPlaylist.addSong(song1);
        testPlaylist.addSong(song2);
        testPlaylist.addSong(song3);
        testPlayer = new Player(new PlayerUI());
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void loadNextSongFromListTest() {
        testPlayer.setWorkingPlaylist(testPlaylist);
        testPlayer.loadNextSongFromList();
        assertEquals("Dont You Worry Child", testPlayer.getWorkingSong().getTitle());
    }
    
    @Test
    public void skipSongTest() {   
        testPlayer.setWorkingPlaylist(testPlaylist);
        testPlayer.loadNextSongFromList();
        testPlayer.loadNextSongFromList();
        assertEquals("Kickstart My Heart", testPlayer.getWorkingSong().getTitle());
    }
    
    @Test
    public void playSongTest() {
        testPlayer.setWorkingPlaylist(testPlaylist);
        testPlayer.loadNextSongFromList();
        try {Thread.sleep(1000);} catch (InterruptedException ex) {}
        testPlayer.playWorkingSong();
        try {Thread.sleep(500);} catch (InterruptedException ex) {}
        assertEquals(MediaPlayer.Status.PLAYING, testPlayer.getMediaControllerStatus());
    }
    
    @Test
    public void stopSongTest() {
        testPlayer.setWorkingPlaylist(testPlaylist);
        testPlayer.loadNextSongFromList();
        try {Thread.sleep(1000);} catch (InterruptedException ex) {}
        testPlayer.playWorkingSong();
        testPlayer.stopWorkingSong();
        try {Thread.sleep(500);} catch (InterruptedException ex) {}
        assertEquals(MediaPlayer.Status.STOPPED, testPlayer.getMediaControllerStatus());
    }
}