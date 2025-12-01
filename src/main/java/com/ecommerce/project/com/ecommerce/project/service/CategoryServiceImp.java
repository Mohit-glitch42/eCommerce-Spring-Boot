package com.ecommerce.project.com.ecommerce.project.service;

import com.ecommerce.project.com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{

    private List<Category> categories=new ArrayList<>();
    //kepping track of categories
    private Long nextId=1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
    categories.add(category);
    }
}
