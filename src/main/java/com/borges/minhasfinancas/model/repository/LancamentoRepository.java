package com.borges.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.borges.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
