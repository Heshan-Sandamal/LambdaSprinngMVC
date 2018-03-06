package com.sysco.test.service;

import com.sysco.test.entities.Item;
import com.sysco.test.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDAO;


    public int addItem(Item item){
        return itemDAO.addItem(item);
    }

    public Item selectItem(int id){
        return itemDAO.selectItem(id);
    }
}
