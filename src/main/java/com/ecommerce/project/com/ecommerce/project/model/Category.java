package com.ecommerce.project.com.ecommerce.project.model;

public class Category {
    private Long categoryId;
    private String categoryName;

    // ✅ No-args constructor required by Jackson
    public Category() {
    }

    // Optional convenience constructor
    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
