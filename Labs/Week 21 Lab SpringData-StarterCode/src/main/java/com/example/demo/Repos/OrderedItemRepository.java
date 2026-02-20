package com.example.demo.Repos;

import com.example.demo.Models.OrderedItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderedItemRepository extends CrudRepository<OrderedItem, Long> {

}
