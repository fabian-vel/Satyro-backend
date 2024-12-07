package com.fabian_velasquez.satyro_backend.application.mapper;

import com.fabian_velasquez.satyro_backend.application.dto.CategoryDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.CategoryRequest;
import com.fabian_velasquez.satyro_backend.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryApplicationMapper {

    CategoryDTO toCategoryDTO(Category category);
    List<CategoryDTO> toCategoryDTOs(List<Category> categories);

    Category toCategory(CategoryRequest categoryRequest);
}
