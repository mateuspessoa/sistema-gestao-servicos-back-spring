package com.servico.backservico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> buscarTodos(){
		return servicoRepository.findAll();
	}
	
	public Servico inserir(Servico servico) {
		//return servicoRepository.save(servico);
		//OU
		Servico servicoBanco = servicoRepository.saveAndFlush(servico);
		return servicoBanco;
	}
	
	public Servico alterar(Servico servico) {
		return servicoRepository.saveAndFlush(servico);
	}
	
	public void excluir(Long id) {
		Servico servico = servicoRepository.findById(id).get();
		servicoRepository.delete(servico);
	}

}
