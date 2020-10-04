package com.formacionbdi.springboot.app.item.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import com.formacionbdi.springboot.app.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ItemController {

	//@Qualifier("kjkjk") alternativa a @Primary, definint @Service("serviceRestTemplate" o "serviceFeign")
	public ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		return itemService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Producto producto = Producto.builder().id(id).nombre("Camara Sony").precio(500.00).build();
		return Item.builder().producto(producto).cantidad(cantidad).build();
	}
}
