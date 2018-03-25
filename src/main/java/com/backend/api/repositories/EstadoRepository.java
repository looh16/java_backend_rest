package com.backend.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.api.models.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
