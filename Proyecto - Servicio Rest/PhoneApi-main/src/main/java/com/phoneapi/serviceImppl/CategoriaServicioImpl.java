package com.phoneapi.serviceImppl;

import com.phoneapi.model.Categoria;
import com.phoneapi.repository.CategoriaRepositorio;
import com.phoneapi.service.iCategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicioImpl implements iCategoriaServicio {
    @Autowired
    CategoriaRepositorio repositorio;

    @Override
    public List<Categoria> listarCategoria() {
        return repositorio.findAll();
    }

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return repositorio.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return repositorio.save(categoria);
    }

    @Override
    public void eliminarCategoria(Integer id_categoria) {
        repositorio.deleteById(id_categoria);
    }

    @Override
    public Categoria listarCategoriaPorId(Integer id_categoria) {
        return repositorio.findById(id_categoria).orElse(null);
    }
}
