package org.example;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class User {
    private String email;
    private List<Movie> favorites;

    User(String email, List<Movie> favorites) {
        if(email == null || email.isEmpty())throw new IllegalArgumentException("Email Can not be null or empty");
        else {
            this.email = email;
        }
        this.favorites = favorites;
    }


    public List<Movie> getFavorites() {
        return favorites;
    }
    public void setFavorites(Movie favorite) {
        this.favorites.add(favorite);
    }
    public String getEmail() {return email;}
    public void setEmail(String email) {
        if(email == null || email.isEmpty())throw new IllegalArgumentException("Email Can not be null or empty");
        else{
            this.email = email;
        }
    }

    public void deleteFavorites(Movie favorite){
        this.favorites.remove(favorite);
    }

    public void seeDetails(){
        System.out.println("Email: " + email);
        System.out.println("Favorite Movies:");
        for (Movie movie : favorites) {
            System.out.println("- " + movie.getTitle());
        }
    }


    public List<Movie> searchInFavorites(String query){
        List<Movie> searchResults = new ArrayList<>();
        if(query.isEmpty() || query == null)return  searchResults;
        for (Movie movie : favorites) {
            if (movie.getTitle().contains(query)
                    || movie.getCategory().contains(query)
                    || movie.getCast().contains(query)) {
                searchResults.add(movie);
            }
        }
        Collections.sort(searchResults, Comparator.comparing(Movie::getTitle));
        return searchResults;
    }

    public List<Movie> search(String query,List<Movie> Movies){

        List<Movie> searchResults = new ArrayList<>();

        if(query.isEmpty() || query == null)return searchResults;
        for (Movie movie : Movies) {
            if (movie.getTitle().contains(query)
                    || movie.getCategory().contains(query)
                    || movie.getCast().contains(query)) {
                searchResults.add(movie);
            }
        }
        Collections.sort(searchResults, Comparator.comparing(Movie::getTitle));
        return searchResults;
    }

}
