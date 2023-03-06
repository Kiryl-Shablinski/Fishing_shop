package com.example.fishing_shop.repos;

import com.example.fishing_shop.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemModel, Long> {
}
