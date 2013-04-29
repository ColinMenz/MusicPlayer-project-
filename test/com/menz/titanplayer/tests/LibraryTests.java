package com.menz.titanplayer.tests;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.menz.titanplayer.domain.Song;
import com.menz.titanplayer.domain.Library;
import com.menz.titanplayer.ui.PlayerUI;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rich
 */
public class LibraryTests {
    
        Library myLibrary;
        Song song1 = new Song("Dont You Worry Child", "Swedish House Mafia");
        Song song2 = new Song("Kickstart My Heart", "Motley Crue");
        Song song3 = new Song("Taken Care of Business", "BTO");
        
    public LibraryTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        myLibrary = new Library(new PlayerUI());
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void emptyLibraryTest() {
	assertEquals(0, myLibrary.songCount());
    }
    
    @Test
    public void addSongTest() {
	myLibrary.addSong(song1);
	myLibrary.addSong(song2);
	assertEquals(2, myLibrary.songCount());	
    }
    
    @Test
    public void removeSongTest() {
	myLibrary.addSong(song1);
	myLibrary.addSong(song2);
	myLibrary.removeSong(song1);
	assertEquals(1, myLibrary.songCount());
    }
    
    @Test
    public void sortLibraryByTitleTest() {
        myLibrary.addSong(song1);
        myLibrary.addSong(song2);
	myLibrary.addSong(song3);
        
        myLibrary.sortLibraryByTitle();
        assertEquals("Dont You Worry Child", myLibrary.getSongByIndex(0).getTitle());
        assertEquals("Kickstart My Heart", myLibrary.getSongByIndex(1).getTitle());
        assertEquals("Taken Care of Business", myLibrary.getSongByIndex(2).getTitle());
    }
    
    @Test
    public void sortLibraryByArtistTest() {
        myLibrary.addSong(song1);
        myLibrary.addSong(song2);
	myLibrary.addSong(song3);
        
        myLibrary.sortLibraryByArtist();
        assertEquals("Taken Care of Business", myLibrary.getSongByIndex(0).getTitle());
        assertEquals("Kickstart My Heart", myLibrary.getSongByIndex(1).getTitle());
        assertEquals("Dont You Worry Child", myLibrary.getSongByIndex(2).getTitle());
    }
}