package com.fabian_velasquez.satyro_backend.application.usecases;

import com.fabian_velasquez.satyro_backend.application.dto.CategoryDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategory();

    void createCategory(CategoryRequest categoryRequest);

    void updateCategory(CategoryRequest categoryRequest);

    void deleteCategory(CategoryRequest categoryRequest);

    CategoryDTO getCategtoryById(CategoryRequest categoryRequest);
}
