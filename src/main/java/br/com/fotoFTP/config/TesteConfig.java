package br.com.fotoFTP.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fotoFTP.entities.Pessoa;
import br.com.fotoFTP.repositories.PessoaRepository;
 
@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa(null, "Gabriel", "Senha", null);
		pessoaRepository.saveAll(Arrays.asList(p1));
		
	}

}
