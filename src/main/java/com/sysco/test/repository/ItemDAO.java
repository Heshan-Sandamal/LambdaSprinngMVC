package com.sysco.test.repository;

import com.sysco.test.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int addItem(Item item){
        String sql = "INSERT INTO item (name, category, vendor, stock)"
                + " VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,new Object[]{ item.getName(), item.getCategory(), item.getVendor(), item.getStock()});
    }

}
