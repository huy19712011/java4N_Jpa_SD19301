package com.example.java4n_jpa_sd19301.service;


import com.example.java4n_jpa_sd19301.entity.Category;
import com.example.java4n_jpa_sd19301.repository.CategoryRepository;

import java.util.ArrayList;

public class CategoryService {

    CategoryRepository categoryRepository = new CategoryRepository();

    public ArrayList<Category> getCategories() {

        return categoryRepository.getCategories();
    }

    public Category getCategoryById(Long id) {

        return categoryRepository.getCategoryById(id);
    }
}
