package com.sysco.test.resources;

import com.sysco.test.entities.Greeting;
import com.sysco.test.entities.Item;
import com.sysco.test.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemResource {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/v1.0/items/add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Responds with item, {Name}",
            notes = "Adding items to database",
            response = Item.class)
    public int addItem(@RequestBody Item item) {
        System.out.println(item.getName());
        System.out.println(item.getCategory());
        return itemService.addItem(item);
    }


    @RequestMapping(value = "/v1.0/items", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Select  item, {id}",
            notes = "select item from database",
            response = Item.class)
    public String selectItem(@RequestParam("id") String id) {
        return itemService.selectItem(Integer.parseInt(id));
    }



}
