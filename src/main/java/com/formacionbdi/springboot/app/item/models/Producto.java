package com.formacionbdi.springboot.app.item.models;

import java.util.Date;

import lombok.Data;
@Data
public class Producto {

	private Long id;
	private String nombre;
	private Double precio;
	private Date createAt;

}