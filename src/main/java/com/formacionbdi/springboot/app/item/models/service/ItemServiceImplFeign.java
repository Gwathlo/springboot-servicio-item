package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;
import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Primary
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

	@Override
	public Producto save(Producto producto) {
		return productoClienteRest.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return productoClienteRest.editar(producto, id);
	}

	@Override
	public void delete(Long id) {
		productoClienteRest.eliminar(id);
		
	}



}
