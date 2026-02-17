package lk.ijse.posebackend.service.impl;

import lk.ijse.posebackend.dto.ItemDTO;
import lk.ijse.posebackend.entity.Item;
import lk.ijse.posebackend.repository.ItemRepository;
import lk.ijse.posebackend.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemRepository.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        itemRepository.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void deleteItem(String code) {
        itemRepository.deleteById(code);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            itemDTOS.add(modelMapper.map(item, ItemDTO.class));
        }
        return itemDTOS;
    }
}