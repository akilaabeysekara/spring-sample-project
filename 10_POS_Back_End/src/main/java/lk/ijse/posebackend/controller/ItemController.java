package lk.ijse.posebackend.controller;

import lk.ijse.posebackend.dto.ItemDTO;
import lk.ijse.posebackend.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping
    public void saveItem(@RequestBody ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
    }

    @PutMapping
    public void updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
    }

    @DeleteMapping("/{code}")
    public void deleteItem(@PathVariable String code) {
        itemService.deleteItem(code);
    }

    @GetMapping
    public Iterable<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }
}