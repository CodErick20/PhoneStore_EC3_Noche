package Proyecto.PhoneStore.jpa.repositorios;

import org.springframework.data.repository.CrudRepository;

import Proyecto.PhoneStore.jpa.modelo.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {
 
}
