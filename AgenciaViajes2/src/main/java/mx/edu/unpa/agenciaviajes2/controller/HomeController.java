package mx.edu.unpa.agenciaviajes2.controller;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.edu.unpa.agenciaviajes2.domain.Paquete;
import mx.edu.unpa.agenciaviajes2.service.PaqueteService;

@Controller
public class HomeController {
	
	@Autowired
	private PaqueteService paqueteService;
	//private StudentRepository studentRepository;
	//OBTENER -> Ejecuta este método para encontrar la vista app.html
	// Responder al navegador
	@GetMapping(path = "/")
	public String index(Model model) {
		System.out.println(">>> Entrando al indexx()");
		
		Paquete paquete = new Paquete();

		
		Iterable<Paquete> paqueteList = paqueteService.findAll();

		
		
		model.addAttribute("paquete", paquete);	
		model.addAttribute("paqueteList", paqueteList);	
		
		return "app";
	}
	
	@GetMapping("/fnd")
	public String read(Paquete paquete, Model model) {
		String url = "";
		if (paquete.getId() != null) {
			LinkedList<Paquete> paqueteList = new LinkedList<Paquete>();
			try {
				Optional<Paquete> oPaquete = paqueteService.findById(paquete.getId());
				paqueteList.add(oPaquete.get());
				model.addAttribute("paqueteList", paqueteList);
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
	public String add(Paquete paquete) {
		return "add.html";
	}
	
	@GetMapping("/upd/{id}")
	public String upd(@PathVariable(value = "id") String id, Model model) {
		Optional<Paquete> oPaquete = paqueteService.findById(id);
		model.addAttribute("paquete", oPaquete);
		
		return "/upd";
	}
	
	@PostMapping("/save")
	public String save(Paquete Paquete) {
		if(Paquete != null) {
			paqueteService.save(Paquete);
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/create")
	public String create(Paquete paquete) {
		paqueteService.save(paquete);
		return "redirect:/";
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable(value = "id") String id) {
	    paqueteService.deleteById(id);
	    return "redirect:/";
	}
	
	
}
