package com.borges.minhasfinancas.service;

import java.util.List;
import com.borges.minhasfinancas.model.entity.Lancamento;
import com.borges.minhasfinancas.model.enums.StatusLancamento;

public interface LancamentoService {

	Lancamento salvar(Lancamento lancamento);

	Lancamento autualizar(Lancamento lancamento);

	void deletar(Lancamento lancamento);

	List<Lancamento> buscar(Lancamento lancamentoFiltro);

	void autualizarStatus(Lancamento lancamento, StatusLancamento status);
	
	void validar(Lancamento lancamento);

}
