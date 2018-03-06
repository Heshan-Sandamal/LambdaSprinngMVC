package com.sysco.test.dao;

import com.sysco.test.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int addItem(Item item){
        String sql = "INSERT INTO item (name, category, vendor, stock)"
                + " VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,new Object[]{ item.getName(), item.getCategory(), item.getVendor(), item.getStock()});
    }


    public Item selectItem(int id){

        String sql = "Select * FROM item where id=?";
        return (Item) this.jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper(Item.class));
    }




}
