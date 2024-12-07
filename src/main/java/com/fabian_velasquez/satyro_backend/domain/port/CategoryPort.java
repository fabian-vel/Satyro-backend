package com.fabian_velasquez.satyro_backend.domain.port;

import com.fabian_velasquez.satyro_backend.application.dto.request.CategoryRequest;
import com.fabian_velasquez.satyro_backend.domain.model.Category;

import java.util.List;

public interface CategoryPort {


    List<Category> getAll();

    void save(Category category);

    void update(Category category);

    void delete(CategoryRequest categoryRequest);

    Category getById(CategoryRequest categoryRequest);
}
