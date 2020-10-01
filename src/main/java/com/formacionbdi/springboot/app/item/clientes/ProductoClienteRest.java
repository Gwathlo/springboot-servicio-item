package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
	
	@GetMapping("/listar")
	// mapping del endpoint
	public List<Producto> listar();
	
	@GetMapping("/listar/{id}")
	Producto obtenerProducto(@PathVariable Long id);

}
