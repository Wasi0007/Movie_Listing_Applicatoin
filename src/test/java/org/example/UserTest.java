package org.example;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
public class UserTest {
    private User user;

    @Before
    public void setUp() {
        List<Movie> favorites = new ArrayList<>();
        user = new User("t1@gmail.com", favorites);
    }

    @Test
    public void testGetEmail() {
        assertEquals("t1@gmail.com", user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("t2@gmail.com");
        assertEquals("t2@gmail.com", user.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullEmail() {
        user.setEmail("");
    }

    @Test
    public void testGetFavoritesInitiallyEmpty() {
        assertEquals(0, user.getFavorites().size());
    }

    @Test
    public void testSetFavorites() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);

        user.setFavorites(movie);
        assertEquals(1, user.getFavorites().size()); // Testing Number of movies
        assertTrue(user.getFavorites().contains(movie)); // Testing Favourite movies
    }

    @Test
    public void testGetFavoritesAfterAddingMultipleMovies() {
        List<String> cast = new ArrayList<>();
        cast.add("Shakib Khan");
        Movie movie1 = new Movie("Priotoma", cast, "Action", "2023", 10000000);
        Movie movie2 = new Movie("Dorod", cast, "Action", "2024", 15000000);
        Movie movie3 = new Movie("Dorod2", cast, "Action", "2024", 15000000);
        user.setFavorites(movie1);
        user.setFavorites(movie2);
        assertEquals(2, user.getFavorites().size());
        assertTrue(user.getFavorites().contains(movie1));
        assertTrue(user.getFavorites().contains(movie2));
        assertFalse(user.getFavorites().contains(movie3));
    }

    @Test
    public void testFavouriteDelete(){
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        user.deleteFavorites(movie);
        assertFalse(user.getFavorites().contains(movie));
    }

    @Test
    public void testDetails(){
        user.seeDetails();
    }


    @Test
    public void testSearchInFavoritesWithTitleMatch() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        user.setFavorites(movie);


        List<Movie> searchResults = user.searchInFavorites("Batman");
        assertEquals(1, searchResults.size());
        assertEquals("Batman", searchResults.get(0).getTitle());
    }

    @Test
    public void testSearchInFavoritesWithCategoryMatch() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        user.setFavorites(movie);
        Movie movie1 = new Movie("Batman2", cast, "Action", "March 2022", 200000000);
        user.setFavorites(movie1);

        List<Movie> searchResults = user.searchInFavorites("Action");
        assertEquals(2, searchResults.size());
    }

    @Test
    public void testSearchInFavoritesWithCastMatch() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        cast.add("Shakib khan");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        user.setFavorites(movie);

        Movie movie1 = new Movie("Batman2", cast, "Action", "March 2022", 200000000);
        user.setFavorites(movie1);

        List<Movie> searchResults = user.searchInFavorites("Shakib khan");
        assertEquals(2, searchResults.size());
    }

    @Test
    public void testSearchInFavoritesWithNoMatch() {
        List<Movie> searchResults = user.searchInFavorites("Superman");
        assertEquals(0, searchResults.size());
    }


    @Test
    public void testSearchInFavoritesOrder() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        user.setFavorites(movie);
        Movie movie1 = new Movie("Batman2", cast, "Action", "March 2022", 200000000);
        user.setFavorites(movie1);

        List<String> cast2 = new ArrayList<>();
        cast2.add("Shakib Khan");
        Movie movie2 = new Movie("Batman3", cast2, "Action", "March 2022", 200000000);
        user.setFavorites(movie2);

        List<Movie> searchResults = user.searchInFavorites("Robert");
        assertEquals(2, searchResults.size());
        assertEquals("Batman", searchResults.get(0).getTitle());
        assertEquals("Batman2", searchResults.get(1).getTitle());
    }

    @Test
    public void testSearch() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);


        List<Movie> searchResults = user.search("Batman",movieList);
        assertEquals(1, searchResults.size());
        assertEquals("Batman", searchResults.get(0).getTitle());
    }

    @Test
    public void testSearchWithCategoryMatch() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        Movie movie2 = new Movie("Batman", cast, "Funny", "March 2022", 200000000);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        movieList.add(movie2);

        List<Movie> searchResults = user.search("Action",movieList);
        assertEquals(1, searchResults.size());
    }

    @Test
    public void testSearchWithCastMatch() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        Movie movie2 = new Movie("Batman", cast, "Funny", "March 2022", 200000000);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        movieList.add(movie2);

        List<Movie> searchResults = user.search("Robert",movieList);
        assertEquals(2, searchResults.size());
    }

    @Test
    public void testSearchWithNoMatch() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        Movie movie2 = new Movie("Batman", cast, "Funny", "March 2022", 200000000);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        movieList.add(movie2);

        List<Movie> searchResults = user.search("Superman",movieList);
        assertEquals(0, searchResults.size());
    }

    @Test
    public void testSearchWithEmptyQuery() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        Movie movie2 = new Movie("Batman", cast, "Funny", "March 2022", 200000000);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        movieList.add(movie2);

        List<Movie> searchResults = user.search("",movieList);
        assertEquals(0, searchResults.size());
    }

    @Test
    public void testSearchOrder() {
        List<String> cast = new ArrayList<>();
        cast.add("Robert");
        Movie movie = new Movie("Batman", cast, "Action", "March 2022", 200000000);
        Movie movie1 = new Movie("Batman2", cast, "Action", "March 2022", 200000000);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie);

        List<String> cast2 = new ArrayList<>();
        cast2.add("Shakib Khan");
        Movie movie2 = new Movie("Batman3", cast2, "Action", "March 2022", 200000000);
        movieList.add(movie2);

        List<Movie> searchResults = user.search("Robert",movieList);
        assertEquals(2, searchResults.size());
        assertEquals("Batman", searchResults.get(0).getTitle());
        assertEquals("Batman2", searchResults.get(1).getTitle());
    }
}