package com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc;

import com.fabian_velasquez.satyro_backend.application.dto.request.CategoryRequest;
import com.fabian_velasquez.satyro_backend.domain.model.Category;
import com.fabian_velasquez.satyro_backend.domain.port.CategoryPort;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.jdbc.row_mapper.CategoryRowMapper;
import com.fabian_velasquez.satyro_backend.infrastructure.adapters.mapper.CategoryAdapterMapper;
import com.fabian_velasquez.satyro_backend.shared.utils.SqlQueryUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryJdbcAdapter implements CategoryPort {

    private final SqlQueryUtils sqlQueryUtils = SqlQueryUtils.getInstance();
    private final CategoryAdapterMapper categoryAdapterMapper;

    JdbcTemplate jdbcTemplate;

    public CategoryJdbcAdapter(DataSource dataSource, CategoryAdapterMapper categoryAdapterMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.categoryAdapterMapper = categoryAdapterMapper;
    }

    @Override
    public List<Category> getAll() {
        String sql = sqlQueryUtils.getQuery("Select_category_getAll");
        return categoryAdapterMapper.toCategoryList(jdbcTemplate.query(sql, new CategoryRowMapper()));
    }

    @Override
    public void save(Category category) {
        String sql = sqlQueryUtils.getQuery("Inset_category");

        jdbcTemplate.update(sql,
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getState(),
                category.getCreatedAt()
        );
    }

    @Override
    public void update(Category category) {
        String sql = sqlQueryUtils.getQuery("Update_category");

        jdbcTemplate.update(sql,
                category.getName(),
                category.getDescription(),
                category.getState(),
                category.getUpdatedAt(),
                category.getId()
        );
    }

    @Override
    public void delete(CategoryRequest categoryRequest) {
        String sql = sqlQueryUtils.getQuery("Delete_category");
        jdbcTemplate.update(sql, categoryRequest.getId()) ;
    }

    @Override
    public Category getById(CategoryRequest categoryRequest) {
        String sql = sqlQueryUtils.getQuery("Select_category_byId");

        try {
            return categoryAdapterMapper.toCategory(
                    jdbcTemplate.queryForObject(sql, new CategoryRowMapper(),
                            categoryRequest.getId()));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
