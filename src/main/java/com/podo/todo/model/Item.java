package com.podo.todo.model;

import com.podo.todo.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Integer itemId;
    private String description;

    public static Item sample() {
        return Item.builder()
                .itemId(0)
                .description("description")
                .build();
    }

    public static Item from(ItemEntity itemEntity) {
        return Item.builder()
                .itemId(itemEntity.getItemId())
                .description(itemEntity.getDescription())
                .build();
    }

    public static Item from(RequestedItem requestedItem) {
        return Item.builder()
                .description(requestedItem.getDescription())
                .build();
    }
}
