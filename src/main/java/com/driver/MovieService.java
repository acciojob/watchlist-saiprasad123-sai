package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository repository;

    public String addMovie(Movie movie){
        return repository.addMovie(movie);
    }
    public String addDirector(Director director){
       return repository.addDirector(director);
    }
    public String moviedirector(String movie,String director){

      return repository.moviedirector(movie,director);
    }

    public Movie getMovieByName(String name){


       return repository.getMovieByName(name);
    }

    public Director getDirectorByName(String name){


        return repository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String director){

        return repository.getMoviesByDirectorName(director);
    }

    public List<String> getAllMovies(){
       return repository.getAllMovies();
    }

    public String deleteDirectorByName(String director){

       return repository.deleteDirectorByName(director);

    }

    public String deleteDirectors(){

       return repository.deleteDirectors();

    }
}
