package com.podo.todo.service;

import com.podo.todo.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getItems();
    Optional<Item> getItem(int itemId);
    Integer createItem(Item item);
    Item updateItem(int itemId, Item item);
    void deleteItem(int itemId);
}
