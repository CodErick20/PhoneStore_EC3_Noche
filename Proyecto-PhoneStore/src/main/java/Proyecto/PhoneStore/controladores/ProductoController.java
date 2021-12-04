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

import Proyecto.PhoneStore.jpa.modelo.Producto;
import Proyecto.PhoneStore.jpa.servicios.ProductoServicio;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoServicio servicio;

	@RequestMapping("/listarTodo")
	public String listarEstudiantes(Model model) {
		List<Producto> listaProductos = servicio.buscarTodo();
		model.addAttribute("listaProductos", listaProductos);
		return "/moduloProductos/listarTodo";
	}

	@RequestMapping("/nuevo")
	public String nuevoProducto(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "/moduloProductos/nuevoProducto";
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearProducto(@ModelAttribute("producto") Producto producto) {
		servicio.crear(producto);
		return "redirect:/productos/listarTodo";
	}

	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarEstudiante(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloProductos/editarProducto");
		Producto producto = servicio.buscarPorID(id);
		mav.addObject("producto", producto);

		return mav;
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminarEstudiante(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
		;
		return "redirect:/productos/listarTodo";
	}

	

}
