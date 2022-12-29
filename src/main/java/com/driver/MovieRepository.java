package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {
HashMap<String,Movie> moviedb=new HashMap<>();
    HashMap<String,Director> directordb=new HashMap<>();

    HashMap<String, List<String>> moviedirectordb=new HashMap<>();

    public String addMovie(Movie movie){
       moviedb.put(movie.getName(),movie);
        return "success";
    }
    public String addDirector(Director director){
        directordb.put(director.getName(),director);
        return "success";
    }
    public String moviedirector(String movie,String director){

        if(moviedirectordb.containsKey(director)){
            moviedirectordb.get(director).add(movie);
        }
        else{
            moviedirectordb.put(director,new ArrayList<>());
            moviedirectordb.get(director).add(movie);
        }

        return "success";
    }

    public Movie getMovieByName(String name){


        return moviedb.getOrDefault(name,null);
    }

    public Director getDirectorByName(String name){


        return directordb.getOrDefault(name,null);
    }

    public List<String> getMoviesByDirectorName(String director){

       return moviedirectordb.getOrDefault(director,null);
    }

    public List<String> getAllMovies(){
        List<String> res = new ArrayList<>();
        for(String name:moviedb.keySet())
            res.add(name);
        return res;
    }

    public String deleteDirectorByName(String director){

        if(directordb.containsKey(director)){
            if(moviedirectordb.containsKey(director)){
                List<String> list = moviedirectordb.get(director);
                for(String s:list){
                    moviedb.remove(s);
                }
                moviedirectordb.remove(director);
            }
            directordb.remove(director);
        }
            return "success";

    }

    public String deleteDirectors(){

        for(String director:directordb.keySet()){
            if(moviedirectordb.containsKey(director)){
                List<String> list = moviedirectordb.get(director);
                for(String s:list){
                    moviedb.remove(s);
                }
                moviedirectordb.remove(director);
            }
            directordb.remove(director);
        }
        return "success";

    }




}
