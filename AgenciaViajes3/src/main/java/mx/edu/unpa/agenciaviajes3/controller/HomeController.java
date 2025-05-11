package mx.edu.unpa.agenciaviajes3.controller;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.edu.unpa.agenciaviajes3.domain.Cliente;
import mx.edu.unpa.agenciaviajes3.service.ClienteService;

@Controller
public class HomeController {
	
	@Autowired
	private ClienteService clienteService;
	//private StudentRepository studentRepository;
	//OBTENER -> Ejecuta este método para encontrar la vista app.html
	// Responder al navegador
	@GetMapping(path = "/")
	public String index(Model model) {
		System.out.println(">>> Entrando al indexx()");
		
		Cliente cliente = new Cliente();

		
		Iterable<Cliente> clienteList = clienteService.findAll();

		
		
		model.addAttribute("cliente", cliente);	
		model.addAttribute("clienteList", clienteList);	
		
		return "app";
	}
	
	@GetMapping("/fnd")
	public String read(Cliente cliente, Model model) {
		String url = "";
		if (cliente.getId() != null) {
			LinkedList<Cliente> clienteList = new LinkedList<Cliente>();
			try {
				Optional<Cliente> oCliente = clienteService.findById(cliente.getId());
				clienteList.add(oCliente.get());
				model.addAttribute("clienteList", clienteList);
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
	public String add(Cliente cliente) {
		return "add.html";
	}
	
	@GetMapping("/upd/{id}")
	public String upd(@PathVariable(value = "id") String id, Model model) {
		Optional<Cliente> oCliente = clienteService.findById(id);
		model.addAttribute("cliente", oCliente);
		
		return "/upd";
	}
	
	@PostMapping("/save")
	public String save(Cliente cliente) {
		if(cliente != null) {
			clienteService.save(cliente);
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/create")
	public String create(Cliente cliente) {
		clienteService.save(cliente);
		return "redirect:/";
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable(value = "id") String id) {
	    clienteService.deleteById(id);
	    return "redirect:/";
	}
	
	
}
