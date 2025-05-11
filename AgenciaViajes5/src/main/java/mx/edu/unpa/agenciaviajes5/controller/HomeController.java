package mx.edu.unpa.agenciaviajes5.controller;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.edu.unpa.agenciaviajes5.domain.Transporte;
import mx.edu.unpa.agenciaviajes5.service.TransporteService;

@Controller
public class HomeController {

	@Autowired
	private TransporteService transporteService;
	
	@GetMapping(path="/")
	public String index(Model model) {
		System.out.println(">>> Entrando al index()");
		Transporte transporte = new Transporte();
		
		Iterable<Transporte> transporteList = transporteService.findAll();
		
		
		
		
		model.addAttribute("transporte",transporte);
		model.addAttribute("transporteList", transporteList);
		
		return "app";
		
	}
	
	@GetMapping("/fnd")
	public String read(Transporte transporte, Model model) {
		String url = "";
		if (transporte.getId() != null) {
			LinkedList<Transporte> transporteList = new LinkedList<Transporte>();
			try {
				Optional<Transporte> oTransporte = transporteService.findById(transporte.getId());
				transporteList.add(oTransporte.get());
				model.addAttribute("transporteList", transporteList);
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
	public String add(Transporte transporte) {
		return "add.html";
	}
	
	@GetMapping("/upd/{id}")
	public String upd(@PathVariable(value = "id") String id, Model model) {
		Optional<Transporte> oTransporte = transporteService.findById(id);
		model.addAttribute("transporte", oTransporte);
		
		return "/upd";
	}
	
	@PostMapping("/save")
	public String save(Transporte transporte) {
		if(transporte != null) {
			transporteService.save(transporte);
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/create")
	public String create(Transporte transporte) {
		transporteService.save(transporte);
		return "redirect:/";
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable(value = "id") String id) {
	    transporteService.deleteById(id);
	    return "redirect:/";
	}
	
	
	
}
