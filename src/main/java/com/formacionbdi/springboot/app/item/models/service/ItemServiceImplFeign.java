package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ItemServiceImplFeign implements ItemService {

	public ProductoClienteRest productoClienteRest;
	
	@Override
	public List<Item> findAll() {
		return productoClienteRest.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(productoClienteRest.obtenerProducto(id), cantidad);
	}



}
