package com.backend.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.api.models.Pagamento;

@Repository
public interface PagamentoRepository  extends JpaRepository<Pagamento, Integer> {

}
