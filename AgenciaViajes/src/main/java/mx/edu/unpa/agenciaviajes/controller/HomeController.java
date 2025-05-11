package mx.edu.unpa.agenciaviajes.controller;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.edu.unpa.agenciaviajes.domain.Destino;
import mx.edu.unpa.agenciaviajes.service.DestinoService;

@Controller
public class HomeController {
	
	@Autowired
	private DestinoService destinoService;
	//private StudentRepository studentRepository;
	//OBTENER -> Ejecuta este método para encontrar la vista app.html
	// Responder al navegador
	@GetMapping(path = "/")
	public String index(Model model) {
		System.out.println(">>> Entrando al index()");
		
		Destino destino = new Destino();

		
		Iterable<Destino> destinoList = destinoService.findAll();

		
		
		model.addAttribute("destino", destino);	
		model.addAttribute("destinoList", destinoList);	
		
		return "app";
	}
	
	@GetMapping("/fnd")
	public String read(Destino destino, Model model) {
		String url = "";
		if (destino.getId() != null) {
			LinkedList<Destino> destinoList = new LinkedList<Destino>();
			try {
				Optional<Destino> oDestino = destinoService.findById(destino.getId());
				destinoList.add(oDestino.get());
				model.addAttribute("destinoList", destinoList);
				url = "/qry.html";
			} catch (Exception e) {
				url = "redirect:/";
			}
			
		} else {
			url = "redirect:/";
		}
		return url;
	}
	

	@GetMapping("/add")
	public String add(Destino destino) {
		return "add.html";
	}
	
	@GetMapping("/upd/{id}")
	public String upd(@PathVariable(value = "id") String id, Model model) {
		Optional<Destino> oDestino = destinoService.findById(id);
		model.addAttribute("destino", oDestino);
		
		return "/upd";
	}
	
	@PostMapping("/save")
	public String save(Destino Destino) {
		if(Destino != null) {
			destinoService.save(Destino);
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/create")
	public String create(Destino destino) {
		destinoService.save(destino);
		return "redirect:/";
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable(value = "id") String id) {
	    destinoService.deleteById(id);
	    return "redirect:/";
	}
	
	
}


