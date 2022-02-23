package com.chalenge.ml.enums;

public enum EnumResponseCodes {
	
	SUCCESS (0, "Success"),
	ERROR (99, "ERROR"),
	ERROR_BOOK_AUTHOR (-1, "Author Not Exist"),
	ERROR_BOOK_VOL (-1, "Volumen Not Exist"),
	URL_CLIENT (0, "https://www.googleapis.com/books/v1/volumes?q="),
	APIKEY (0, "AIzaSyBJWosNZPgSyPeNN0UJAlj0hJO8U-Sn4xg");
	
	private Integer codigo;
	private String descripcion;
	
	private EnumResponseCodes(Integer codigo, String descripcion) {
		// TODO Auto-generated constructor stub
		this.codigo=codigo;
		this.descripcion=descripcion;
	}
	
	public Integer getCodigo() {
		return this.codigo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
}
