package com.formacionbdi.springboot.app.item.models;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Producto {

	private Long id;
	private String nombre;
	private Double precio;
	private Date createAt;
	private Integer port;

}
