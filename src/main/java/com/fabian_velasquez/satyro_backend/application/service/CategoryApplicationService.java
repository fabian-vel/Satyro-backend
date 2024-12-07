package com.fabian_velasquez.satyro_backend.application.service;

import com.fabian_velasquez.satyro_backend.application.dto.CategoryDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.CategoryRequest;
import com.fabian_velasquez.satyro_backend.application.mapper.CategoryApplicationMapper;
import com.fabian_velasquez.satyro_backend.application.usecases.CategoryService;
import com.fabian_velasquez.satyro_backend.domain.model.Category;
import com.fabian_velasquez.satyro_backend.domain.port.CategoryPort;
import com.fabian_velasquez.satyro_backend.shared.exception.CategoryException;
import com.fabian_velasquez.satyro_backend.shared.exception.EventException;
import com.fabian_velasquez.satyro_backend.shared.utils.UUIDGenerator;
import com.fabian_velasquez.satyro_backend.shared.utils.UtilDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryApplicationService implements CategoryService {

    private final CategoryPort categoryPort;
    private final CategoryApplicationMapper categoryApplicationMapper;

    private static final String NON_EXISTENT_CATEGORY = "La categoría no existe";

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryApplicationMapper.toCategoryDTOs(categoryPort.getAll());
    }

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = categoryApplicationMapper.toCategory(categoryRequest);

        category.setId(UUIDGenerator.generateUUID());
        category.setCreatedAt(UtilDate.getCurrentTimestamp());

        categoryPort.save(category);
    }

    @Override
    public void updateCategory(CategoryRequest categoryRequest) {
        Category existingCategory = categoryApplicationMapper.toCategory(categoryRequest);

        if(existingCategory != null) {
            categoryPort.update(existingCategory);
        } else {
            throw new CategoryException(NON_EXISTENT_CATEGORY);
        }
    }

    @Override
    public void deleteCategory(CategoryRequest categoryRequest) {
        Category existingCategory = categoryApplicationMapper.toCategory(categoryRequest);

        if(existingCategory != null) {
            categoryPort.delete(categoryRequest);
        } else {
            throw new EventException(NON_EXISTENT_CATEGORY);
        }
    }

    @Override
    public CategoryDTO getCategtoryById(CategoryRequest categoryRequest) {
        Category category = categoryPort.getById(categoryRequest);

        if(category != null) {
            return categoryApplicationMapper.toCategoryDTO(category);
        } else {
            throw new EventException(NON_EXISTENT_CATEGORY);
        }
    }


}
