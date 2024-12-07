package com.fabian_velasquez.satyro_backend.infrastructure.adapters.mapper;

import com.fabian_velasquez.satyro_backend.application.dto.CategoryDTO;
import com.fabian_velasquez.satyro_backend.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryAdapterMapper {

    List<Category> toCategoryList(List<CategoryDTO> categoryDTOList);
    Category toCategory(CategoryDTO categoryDTO);
}
