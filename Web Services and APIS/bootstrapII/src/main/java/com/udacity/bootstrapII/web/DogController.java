package com.udacity.bootstrapII.web;

import com.udacity.bootstrapII.entity.Dog;
import com.udacity.bootstrapII.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is bad request, please follow the API documentation for proper request"),
        @ApiResponse(code=401, message = "Due to security constraint, your access request cannot be authorized"),
        @ApiResponse(code = 500, message = "Server is down, please make sure that Dog microservice is running")
})
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String >>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getDogBreedByID(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String >>(list, HttpStatus.OK);
    }
}
