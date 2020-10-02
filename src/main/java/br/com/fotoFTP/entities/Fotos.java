package br.com.fotoFTP.entities;

import java.io.Serializable;

public class Fotos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String foto0;
	private String foto1;
	private String foto2;
	
	public Fotos() {
		// TODO Auto-generated constructor stub
	}

	public Fotos(String foto0, String foto1, String foto2) {
		super();
		this.foto0 = foto0;
		this.foto1 = foto1;
		this.foto2 = foto2;
	}

	public String getFoto0() {
		return foto0;
	}

	public void setFoto0(String foto0) {
		this.foto0 = foto0;
	}

	public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}

	
	
	

}
