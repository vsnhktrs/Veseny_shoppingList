package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("jdbc")
public class JdbcProductRepasitory implements ProductRepasitory {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    JdbcProductRepasitory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long add(Product product) {
        String query = "insert into product (name, price, category, description, discount) values (" +
                "?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setString(3, product.getCategory());
            ps.setString(4, product.getDescription());
            ps.setDouble(5, product.getDiscount());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public Optional<Product> findby(Long id) {
        String query = "select * from product where id=" + id;
        List<Product> products = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class));
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();
    }
}
