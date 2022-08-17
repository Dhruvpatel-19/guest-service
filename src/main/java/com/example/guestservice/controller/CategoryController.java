package com.example.guestservice.controller;

import com.example.guestservice.entity.Category;
import com.example.guestservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestService/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addCategory" , method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }


    @RequestMapping(value = "/getCategoryById/{id}" , method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable("id") int id){
        return categoryService.getCategoryById(id);
    }

    @RequestMapping(value = "/getAllCategory" , method = RequestMethod.GET)
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @RequestMapping(value = "/updateCategory/{id}" , method = RequestMethod.PUT)
    public Category updateCategory(@PathVariable("id") int id ,@RequestBody Category category){
        return categoryService.updateCategory(id , category);
    }

    @RequestMapping(value = "/deleteCategory/{id}" , method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }
}
