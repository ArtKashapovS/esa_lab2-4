package ru.ssau.esa_lab24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ssau.esa_lab24.models.Item;
import ru.ssau.esa_lab24.repositories.ItemRepository;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void addItem(Item item) {
        itemRepository.save(item);
    }
}
