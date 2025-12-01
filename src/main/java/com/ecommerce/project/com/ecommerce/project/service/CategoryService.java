package com.ecommerce.project.com.ecommerce.project.service;

import com.ecommerce.project.com.ecommerce.project.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
}
