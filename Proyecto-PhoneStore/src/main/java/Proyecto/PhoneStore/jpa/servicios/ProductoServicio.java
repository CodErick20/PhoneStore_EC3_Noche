package Proyecto.PhoneStore.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Proyecto.PhoneStore.jpa.modelo.Producto;
import Proyecto.PhoneStore.jpa.repositorios.ProductoRepositorio;


@Service
@Transactional
public class ProductoServicio {

	@Autowired
	private ProductoRepositorio repositorio;

	public ProductoServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Producto> buscarTodo() {
		return (List<Producto>) repositorio.findAll();  
	}

	public Producto crear(Producto producto) {
		return repositorio.save(producto);
	}

	public Producto actualizar(Producto productoActualizar) {
		Producto productoActual = repositorio.findById(productoActualizar.getId_producto()).get();
		productoActual.setId_producto(productoActualizar.getId_producto());
		productoActual.setNombre(productoActualizar.getNombre());
		productoActual.setUrl_imagen(productoActualizar.getUrl_imagen());
		productoActual.setFecha_Ingreso(productoActualizar.getFecha_Ingreso());
		productoActual.setPrecio_Compra(productoActualizar.getPrecio_Compra());
		productoActual.setStock(productoActualizar.getStock());
		productoActual.setEstado(productoActualizar.getEstado());
		
		Producto productoActualizado = repositorio.save(productoActual);
		return productoActualizado;
	}

	public Producto buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
