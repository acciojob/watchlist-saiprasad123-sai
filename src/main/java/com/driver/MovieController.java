package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService service;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String>  addMovie(@RequestBody() Movie movie){

        return new ResponseEntity<>(service.addMovie(movie), HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String>  addDirector(@RequestBody() Director director){

        return new ResponseEntity<>(service.addDirector(director), HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam() String movie,String director){

        return new ResponseEntity<>(service.moviedirector(movie,director),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){

        Movie res=service.getMovieByName(name);
        if(res==null){
            return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director>  getDirectorByName(@PathVariable("name") String name){

        Director res=service.getDirectorByName(name);
        if(res==null){
            return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.FOUND);

    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name){

        List<String> res = service.getMoviesByDirectorName(name);
        if(res==null){
            return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>>  findAllMovies(){

        List<String> res = service.getAllMovies();
        if(res==null){
            return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res,HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam()String name){

        return new ResponseEntity<>(service.deleteDirectorByName(name),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){

        return new ResponseEntity<>(service.deleteDirectors(),HttpStatus.ACCEPTED);
    }
}
