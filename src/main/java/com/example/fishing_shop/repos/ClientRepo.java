package com.example.fishing_shop.repos;

import com.example.fishing_shop.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<ClientModel,Long> {

}
