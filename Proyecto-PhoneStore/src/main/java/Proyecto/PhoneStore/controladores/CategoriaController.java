package Proyecto.PhoneStore.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Proyecto.PhoneStore.jpa.modelo.Categoria;
import Proyecto.PhoneStore.jpa.servicios.CategoriaServicio;


@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaServicio servicio;

	
	@RequestMapping("/listarTodo")
	public String listarCursos(Model model) {
		List<Categoria> listaCategorias = servicio.buscarTodo();
		model.addAttribute("listaCategorias", listaCategorias);
		return "/moduloCategorias/listarTodo";
	}

	
	@RequestMapping("/nueva")
	public String nuevaCategoria(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		return "/moduloCategorias/nuevaCategoria";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearCategoria(@ModelAttribute("categoria") Categoria categoria) {
		servicio.crear(categoria);
	    return "redirect:/categorias/listarTodo";
	}
	
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarCategoria(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloCategorias/editarCategoria");
	    Categoria categoria = servicio.buscarPorID(id);
	    mav.addObject("categoria", categoria);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarCategorias(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);;
	    return "redirect:/categorias/listarTodo";       
	}
}
