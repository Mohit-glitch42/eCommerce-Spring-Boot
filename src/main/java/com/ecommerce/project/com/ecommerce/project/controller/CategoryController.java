package com.ecommerce.project.com.ecommerce.project.controller;

import com.ecommerce.project.com.ecommerce.project.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private List<Category> categories=new ArrayList<>();

    //teh get mapping fetches the categories from post method and displays them
    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categories;
    }

    //we have been able to add new categories in our api with the help of post mapping
    //we made use of post to help us create new resources on the server
    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categories.add(category);
        return "Category added successfully";
    }
}
