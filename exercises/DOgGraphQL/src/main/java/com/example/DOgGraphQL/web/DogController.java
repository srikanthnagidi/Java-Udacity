package com.example.DOgGraphQL.web;

import com.example.DOgGraphQL.entity.Dog;
import com.example.DOgGraphQL.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    private DogService dogService;
    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }
    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String >> getDogBreeds(){
        List<String> list = dogService.retrieveDogBreeds();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id){
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }
    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames(){
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}