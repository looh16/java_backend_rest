package com.backend.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.api.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
