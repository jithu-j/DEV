package com.persproj.inventoryservice.controller;

import com.persproj.inventoryservice.dto.InventoryResponse;
import com.persproj.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/inventory")
@RequiredArgsConstructor
public class InventoryController {


    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){

        return inventoryService.isInStock(skuCode);
    }

    @PutMapping("/reduceStock")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void reduceQuantityForSkuCodes(@RequestParam List<String> skuCode){
        inventoryService.reduceQuantityForSkuCodes(skuCode);
    }
}
