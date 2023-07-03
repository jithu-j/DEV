package com.persproj.inventoryservice.service;

import com.persproj.inventoryservice.dto.InventoryResponse;
import com.persproj.inventoryservice.model.Inventory;
import com.persproj.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){

        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                )
                .toList();
    }

    public void reduceQuantityForSkuCodes(List<String> skuCodes){

        List<Inventory> inventories = inventoryRepository.findBySkuCodeIn(skuCodes);

        inventories.forEach(inventory -> {
            int currentQuantity = inventory.getQuantity();
            log.info("quantity {} is saved", currentQuantity);
            if(currentQuantity > 0) inventory.setQuantity(currentQuantity - 1);
            log.info("quantity {} is saved", inventory.getQuantity());
            inventoryRepository.save(inventory);
        });




    }
}
