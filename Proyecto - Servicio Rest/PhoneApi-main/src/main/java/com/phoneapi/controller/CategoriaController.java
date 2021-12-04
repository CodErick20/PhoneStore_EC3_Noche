package com.phoneapi.controller;


import com.phoneapi.model.Categoria;

import com.phoneapi.service.iCategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
@CrossOrigin(origins = "http://localhost:4200/")
public class CategoriaController {

    @Autowired
    iCategoriaServicio servicio;

    @GetMapping("")
    private ResponseEntity<List<Categoria>> listarCategoria(){
        List<Categoria> cat = servicio.listarCategoria();
        return new ResponseEntity<List<Categoria>>(cat, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Categoria>agregarCategoria(@Validated @RequestBody Categoria categoria){
        Categoria cat = servicio.agregarCategoria(categoria);
        return new ResponseEntity<Categoria>(cat, HttpStatus.OK);
    }

//    @PostMapping("")
//    public ResponseEntity<Void> registrar(@RequestBody Categoria categoria){
//        Categoria pro = servicio.agregarCategoria(categoria);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pro.getId_categoria()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

    @PutMapping("")
    public ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria){
        Categoria obj = servicio.actualizarCategoria(categoria);
        return new ResponseEntity<Categoria>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Categoria obj = servicio.listarCategoriaPorId(id);
        if (obj == null){
            throw new Exception("No se encontro id");
        }
        servicio.eliminarCategoria(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listarPaisPorId(@PathVariable("id") Integer id) throws Exception {
        Categoria obj = servicio.listarCategoriaPorId(id);
        if (obj == null){
            throw new Exception("No se encontro id");
        }
        return new ResponseEntity<Categoria>(obj,HttpStatus.OK);
    }
}
