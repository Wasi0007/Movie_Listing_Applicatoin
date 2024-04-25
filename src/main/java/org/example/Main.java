package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> cast = new ArrayList<>();
        cast.add("Ryunosuke Kamiki");
        cast.add("Mone Kamishiraishi");
        cast.add("Ryo Narita");
        Movie movie = new Movie("Your Name.", cast, "Anime", "July 3, 2016", 4821825);

        List<Movie> favorites = new ArrayList<>();
        User user = new User("t1@gmail.com", favorites);

    }
}