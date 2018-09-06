package com.podo.todo.controller;

import com.podo.todo.exception.NoContentException;
import com.podo.todo.model.Item;
import com.podo.todo.model.RequestedItem;
import com.podo.todo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable int itemId) {
        return itemService.getItem(itemId)
                .orElseThrow(NoContentException::new);
    }

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createItem(@RequestBody RequestedItem requestedItem) {
        return itemService.createItem(Item.from(requestedItem));
    }

    @PutMapping("/items/{itemId}")
    public Item updateItem(@PathVariable int itemId,
                           @RequestBody RequestedItem requestedItem) {
        return itemService.updateItem(itemId, Item.from(requestedItem));
    }

    @DeleteMapping("/items/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable int itemId) {
        itemService.deleteItem(itemId);
    }
}
