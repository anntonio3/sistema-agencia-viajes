package mx.edu.unpa.agenciaviajes4.controller;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.edu.unpa.agenciaviajes4.domain.Reserva;
import mx.edu.unpa.agenciaviajes4.service.ReservaService;

@Controller
public class HomeController {
	
	@Autowired
	private ReservaService reservaService;
	//private StudentRepository studentRepository;
	//OBTENER -> Ejecuta este método para encontrar la vista app.html
	// Responder al navegador
	@GetMapping(path = "/")
	public String index(Model model) {
		System.out.println(">>> Entrando al index()");
		
		Reserva reserva = new Reserva();

		
		Iterable<Reserva> reservaList = reservaService.findAll();

		
		
		model.addAttribute("reserva", reserva);	
		model.addAttribute("reservaList", reservaList);	
		
		return "app";
	}
	
	@GetMapping("/fnd")
	public String read(Reserva reserva, Model model) {
		String url = "";
		if (reserva.getId() != null) {
			LinkedList<Reserva> reservaList = new LinkedList<Reserva>();
			try {
				Optional<Reserva> oReserva = reservaService.findById(reserva.getId());
				reservaList.add(oReserva.get());
				model.addAttribute("reservaList", reservaList);
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
	public String add(Reserva reserva) {
		return "add.html";
	}
	
	@GetMapping("/upd/{id}")
	public String upd(@PathVariable(value = "id") String id, Model model) {
		Optional<Reserva> oReserva = reservaService.findById(id);
		model.addAttribute("reserva", oReserva);
		
		return "/upd";
	}
	
	@PostMapping("/save")
	public String save(Reserva reserva) {
		if(reserva != null) {
			reservaService.save(reserva);
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/create")
	public String create(Reserva reserva) {
		reservaService.save(reserva);
		return "redirect:/";
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable(value = "id") String id) {
	    reservaService.deleteById(id);
	    return "redirect:/";
	}
	
	
}
