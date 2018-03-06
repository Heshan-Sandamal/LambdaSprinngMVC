package com.sysco.test.service;

import com.sysco.test.entities.Item;
import com.sysco.test.repository.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDAO itemDAO;


    public int addItem(Item item){
        return itemDAO.addItem(item);
    }
}
