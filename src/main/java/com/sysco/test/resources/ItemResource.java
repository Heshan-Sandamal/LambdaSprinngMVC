package com.sysco.test.resources;

import com.sysco.test.entities.Greeting;
import com.sysco.test.entities.Item;
import com.sysco.test.service.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemResource {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/v1.0/item/add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Responds with item, {Name}",
            notes = "Adding items to database",
            response = Greeting.class)
    public int addItem(@RequestBody Item item) {
        System.out.println(item.getName());
        System.out.println(item.getCategory());
        return itemService.addItem(item);
    }

}
