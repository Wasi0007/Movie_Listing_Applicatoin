package org.example;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        List<String> cast = new ArrayList<>();
        cast.add("Ryunosuke Kamiki");
        cast.add("Mone Kamishiraishi");
        cast.add("Ryo Narita");
        movie = new Movie("Your Name.", cast, "Anime", "July 3, 2016", 4821825);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Your Name.", movie.getTitle());
    }
    @Test
    public void testSetTitle() {
        movie.setTitle("Your Name");
        assertEquals("Your Name", movie.getTitle());
    }
    @Test
    public void testGetCategory() {
        assertEquals("Anime", movie.getCategory());
    }

    @Test
    public void testSetCategory() {
        movie.setCategory("Cartoon");
        assertEquals("Cartoon", movie.getCategory());
    }

    @Test
    public void testGetReleaseDate() {
        assertEquals("July 3, 2016", movie.getReleaseDate());
    }

    @Test
    public void testSetReleaseDate() {
        movie.setReleaseDate("August 3, 2016");
        assertEquals("August 3, 2016", movie.getReleaseDate());
    }

    @Test
    public void testGetBudget() {
        assertEquals(Integer.valueOf(4821825), movie.getBudget());
    }

    @Test
    public void testSetBudget() {
        movie.setBudget(1);
        assertEquals(Integer.valueOf(1), movie.getBudget());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBudgetWithNegativeValue() {
        movie.setBudget(-100);
    }

    @Test
    public void testGetCast() {
        List<String> cast = new ArrayList<>();
        cast.add("Ryunosuke Kamiki");
        cast.add("Mone Kamishiraishi");
        cast.add("Ryo Narita");
        assertEquals(cast, movie.getCast());
    }

    @Test
    public void testSetCast() {
        List<String> newCast = new ArrayList<>();
        newCast.add("Aoi Yûki");
        movie.setCast(newCast);
        assertEquals(newCast, movie.getCast());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTitle(){
        movie.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullCast(){
        movie.setCast(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNullCategory(){
        movie.setCategory(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNullReleaseDate(){
        movie.setReleaseDate(null);
    }
}