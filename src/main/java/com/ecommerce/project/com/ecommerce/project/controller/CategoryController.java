package com.ecommerce.project.com.ecommerce.project.controller;

import com.ecommerce.project.com.ecommerce.project.model.Category;
import com.ecommerce.project.com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    //we have been able to add new categories in our api with the help of post mapping
    //we made use of post to help us create new resources on the server
    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category added successfully";
    }
    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        String status=categoryService.deleteCategory(categoryId);
        return status;
    }
}
