package br.com.fotoFTP.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fotoFTP.entities.Pessoa;
import br.com.fotoFTP.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa insert(Pessoa obj) {
		return pessoaRepository.save(obj);
	}
	
}
