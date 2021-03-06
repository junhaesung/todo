package com.podo.todo.service;

import com.podo.todo.entity.ItemEntity;
import com.podo.todo.exception.ResourceNotFoundException;
import com.podo.todo.model.Item;
import com.podo.todo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll().stream()
                .map(Item::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> getItem(int itemId) {
        return itemRepository.findById(itemId)
                .map(Item::from);
    }

    @Override
    @Transactional
    public Integer createItem(Item item) {
        ItemEntity itemEntity = ItemEntity.builder()
                .description(item.getDescription())
                .build();
        itemRepository.saveAndFlush(itemEntity);
        return itemEntity.getItemId();
    }

    @Override
    @Transactional
    public Item updateItem(int itemId, Item item) {
        ItemEntity itemEntity = itemRepository.findById(itemId)
                .orElseThrow(ResourceNotFoundException::new);
        itemEntity.setDescription(item.getDescription());
        itemRepository.saveAndFlush(itemEntity);
        return Item.from(itemEntity);
    }

    @Override
    @Transactional
    public void deleteItem(int itemId) {
        itemRepository.deleteById(itemId);
    }
}
