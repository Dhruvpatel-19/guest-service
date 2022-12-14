package com.example.guestservice.service;

import com.example.guestservice.entity.Category;
import com.example.guestservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category getCategoryById(int id){
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category updateCategory(int id , Category updatedCategory){

        Category category = categoryRepository.findById(id).orElse(null);

        category.setCategory(updatedCategory.getCategory());

        return categoryRepository.save(category);
    }

    public String deleteCategory(int id){

        Category category = categoryRepository.findById(id).orElse(null);
        categoryRepository.deleteById(id);
        return "Category with name "+category.getCategory()+" deleted successfully";
    }
}
