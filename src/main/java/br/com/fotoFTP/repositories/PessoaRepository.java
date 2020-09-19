package br.com.fotoFTP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fotoFTP.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
