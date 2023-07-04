package com.example.fishing_shop.repos;

import com.example.fishing_shop.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<ClientModel,Long> {
    List<ClientModel> findClientModelsByActual(boolean actual);
}
