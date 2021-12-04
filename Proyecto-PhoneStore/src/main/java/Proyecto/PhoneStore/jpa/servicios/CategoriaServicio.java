package Proyecto.PhoneStore.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Proyecto.PhoneStore.jpa.modelo.Categoria;
import  Proyecto.PhoneStore.jpa.repositorios.CategoriaRepositorio;

@Service
@Transactional
public class CategoriaServicio {
	@Autowired
	private CategoriaRepositorio repositorio;

	public CategoriaServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Categoria> buscarTodo() {
		return (List<Categoria>) repositorio.findAll();  
	}

	public Categoria crear(Categoria categoria) {
		return repositorio.save(categoria);
	}

	public Categoria actualizar(Categoria categoriaActualizar) {
		Categoria categoriaActual = repositorio.findById(categoriaActualizar.getId_categoria()).get();
		categoriaActual.setId_categoria(categoriaActualizar.getId_categoria());
		categoriaActual.setNombre(categoriaActualizar.getNombre());
		categoriaActual.setEstado(categoriaActualizar.getEstado());
		
		
		
		
		
		Categoria categoriaActualizado = repositorio.save(categoriaActual);
		return categoriaActualizado;
	}

	public Categoria buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
