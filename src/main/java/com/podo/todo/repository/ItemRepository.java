package com.podo.todo.repository;

import com.podo.todo.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    Optional<ItemEntity> findById(Integer itemId);
    List<ItemEntity> findAll();
}
