package com.example.senai.PrjFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senai.PrjFinal.entities.Finalgame;
import com.example.senai.PrjFinal.repositories.FinalgameRepository;


@Service
public class FinalgameService {

	private final FinalgameRepository finalgameRepository;

	@Autowired
	public FinalgameService(FinalgameRepository finalgameRepository) {
		this.finalgameRepository = finalgameRepository;
	}

	// preparando as buscas por id
	public Finalgame getFinalgameById(Long id) {
		return finalgameRepository.findById(id).orElse(null);
	}

	// preparando a busca geral
	public List<Finalgame> getAllFinalgame() {
		return finalgameRepository.findAll();
	}

	// salvando o Jogo
	public Finalgame saveFinalgame(Finalgame finalgame) {
		return finalgameRepository.save(finalgame);
	}

	// excluindo o Jogo
	public void deleteFinalgame(Long id) {
		finalgameRepository.deleteById(id);
	}
	
}
