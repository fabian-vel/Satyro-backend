package com.fabian_velasquez.satyro_backend.infrastructure.adapters.rest.controller;

import com.fabian_velasquez.satyro_backend.application.dto.CategoryDTO;
import com.fabian_velasquez.satyro_backend.application.dto.request.CategoryRequest;
import com.fabian_velasquez.satyro_backend.application.dto.request.EventRequest;
import com.fabian_velasquez.satyro_backend.application.usecases.CategoryService;
import com.fabian_velasquez.satyro_backend.shared.message.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping({"/getAll"})
    public ResponseEntity<ResponseMessage<List<CategoryDTO>>> getAllEvent() {
        List<CategoryDTO> result;
        result = categoryService.getAllCategory();
        var message = new ResponseMessage<>(200, "getAll, process successful ", result);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage<String>> createEvent(@RequestBody CategoryRequest categoryRequest) {
        categoryService.createCategory(categoryRequest);
        var message = new ResponseMessage<String>(200, "category created successfully", null);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseMessage<String>> updateEvent(@RequestBody CategoryRequest categoryRequest) {
        categoryService.updateCategory(categoryRequest);
        var message = new ResponseMessage<String>(200, "category update successfully", null);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseMessage<String>> deleteEvent(@RequestBody CategoryRequest categoryRequest) {
        categoryService.deleteCategory(categoryRequest);
        var message = new ResponseMessage<String>(200, "category delete successfully", null);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/getById")
    public ResponseEntity<ResponseMessage<CategoryDTO>> getById(@RequestBody CategoryRequest categoryRequest) {
        CategoryDTO result = categoryService.getCategtoryById(categoryRequest);
        var message = new ResponseMessage<>(200, "getById, process successfully", result);
        return ResponseEntity.ok(message);
    }
}
