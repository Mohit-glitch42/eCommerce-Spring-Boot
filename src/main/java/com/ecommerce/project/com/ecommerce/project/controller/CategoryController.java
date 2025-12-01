package com.ecommerce.project.com.ecommerce.project.controller;

import com.ecommerce.project.com.ecommerce.project.model.Category;
import com.ecommerce.project.com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    //at runtime a type of categoryService is injected
    //field injection
    @Autowired
    private CategoryService categoryService;
// constructor injection
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    //teh get mapping fetches the categories from post method and displays them
    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> Categories = categoryService.getAllCategories();
        return new ResponseEntity<>(Categories,HttpStatus.OK);
    }

    //we have been able to add new categories in our api with the help of post mapping
    //we made use of post to help us create new resources on the server
    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category ,
                                                 @PathVariable Long categoryId){
        try {
            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Updated Category with category id: " + categoryId, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
