package org.example;

import java.util.List;

import static java.lang.Math.max;

public class Movie {
    private String title;
    private List<String> cast;
    private String category;
    private String releaseDate;
    private Integer budget;

    Movie(String title, List<String> cast, String category, String releaseDate, Integer budget) {
        if(title == null || title.isEmpty())throw new IllegalArgumentException("Title cannot be null or empty");
        else {
            this.title = title;
        }

        if(cast == null || cast.isEmpty())throw new IllegalArgumentException("cast cannot be null or empty");
        else {
            this.cast = cast;
        }

        if(category == null || category.isEmpty())throw new IllegalArgumentException("category cannot be null or empty");
        else {
            this.category = category;
        }


        if(releaseDate == null || releaseDate.isEmpty())throw new IllegalArgumentException("releaseDate cannot be null or empty");
        else {
            this.releaseDate = releaseDate;
        }


        if(budget > 0)this.budget = budget;
        else throw new IllegalArgumentException("budget must be greater than 0");

    }

    void setTitle(String title) {
        if(title == null || title.isEmpty())throw new IllegalArgumentException("Title cannot be null or empty");
        else {
            this.title = title;
        }
    }
    void setCategory(String category) {
        if(category == null || category.isEmpty())throw new IllegalArgumentException("category cannot be null or empty");
        else {
            this.category = category;
        }
    }
    void setReleaseDate(String releaseDate) {
        if(releaseDate == null || releaseDate.isEmpty())throw new IllegalArgumentException("releaseDate cannot be null or empty");
        else {
            this.releaseDate = releaseDate;
        }
    }

    void setBudget(Integer budget) {
        if(budget > 0)this.budget = budget;
        else throw new IllegalArgumentException("budget must be greater than 0");
    }
    void setCast(List<String> cast) {
        if(cast == null || cast.isEmpty())throw new IllegalArgumentException("cast cannot be null or empty");
        else {
            this.cast = cast;
        }
    }

    String getTitle() {return this.title;}
    String getCategory() {return this.category;}
    String getReleaseDate() {return this.releaseDate;}
    Integer getBudget() {return this.budget;}
    List<String> getCast() {return this.cast;}

}
