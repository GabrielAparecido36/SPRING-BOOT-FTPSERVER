package br.com.fotoFTP.resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.fotoFTP.entities.Fotos;
import br.com.fotoFTP.entities.Pessoa;
import br.com.fotoFTP.services.PessoaService;
import br.com.fotoFTP.services.utils.FTPUploader;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		return ResponseEntity.ok().body(pessoaService.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<Fotos> insert(@RequestParam(name="file") MultipartFile[] file) throws IOException, URISyntaxException{
	//public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj){
	//public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj, @RequestParam(name="file") MultipartFile file) throws IOException{
		FTPUploader ftp = new FTPUploader();
		
		Fotos urlFotos= ftp.Upar(file);
		return ResponseEntity.ok().body(urlFotos);
//		obj = pessoaService.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).body(obj);
		
	}
	 
	
}
