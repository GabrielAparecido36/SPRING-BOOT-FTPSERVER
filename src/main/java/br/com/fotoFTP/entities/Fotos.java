package br.com.fotoFTP.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;

public class Fotos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ElementCollection
	@CollectionTable(name="urlFoto")
	private Set<String>urlFoto = new HashSet<>();
	
	public Fotos() {
		// TODO Auto-generated constructor stub
	}

	public Set<String> getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(Set<String> urlFoto) {
		this.urlFoto = urlFoto;
	}

	
	

}
