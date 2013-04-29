package com.menz.titanplayer.tests;

import com.menz.titanplayer.domain.Song;
import com.menz.titanplayer.domain.Playlist;
import com.menz.titanplayer.ui.PlayerUI;
import org.junit.*;
import static org.junit.Assert.*;

public class PlaylistTests {
    
        Playlist testPlaylist;
        Song song1 = new Song("Dont You Worry Child", "Swedish House Mafia");
        Song song2 = new Song("Kickstart My Heart", "Motley Crue");
        Song song3 = new Song("Taken Care of Business", "BTO");

    
    public PlaylistTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testPlaylist = new Playlist("New Playlist", new PlayerUI());
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void emptyPlaylistTest() {
	assertEquals(0, testPlaylist.songCount());
    }

    @Test
    public void playlistNameTest() {
	assertEquals("New Playlist", testPlaylist.getPlaylistName());
    }
    
    @Test
    public void addSongTest() {
	testPlaylist.addSong(song1);
	testPlaylist.addSong(song2);
	assertEquals(2, testPlaylist.songCount());	
    }
    
    @Test
    public void nextSongInListTest() {
        testPlaylist.addSong(song1);
	testPlaylist.addSong(song2);
        testPlaylist.nextSongInList();
        Song nextSong = testPlaylist.nextSongInList();
	assertEquals("Kickstart My Heart", nextSong.getTitle());
    }
    
}