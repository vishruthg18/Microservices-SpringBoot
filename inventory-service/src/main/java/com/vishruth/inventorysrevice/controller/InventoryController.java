package com.vishruth.inventorysrevice.controller;

import com.vishruth.inventorysrevice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    @GetMapping("/{skucode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("skucode" ) String skuCode){
        return inventoryService.isInStock(skuCode);

    }
}
