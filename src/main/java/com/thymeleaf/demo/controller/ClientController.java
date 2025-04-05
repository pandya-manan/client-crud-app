package com.thymeleaf.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thymeleaf.demo.entity.Client;
import com.thymeleaf.demo.entity.ClientDTO;
import com.thymeleaf.demo.repository.ClientRepository;
import com.thymeleaf.demo.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@GetMapping({"","/"})
	public String indexPage()
	{
		return "index";
	}
	
	@GetMapping("/clients")
	public String getClients(@RequestParam(defaultValue = "0") int page,
	                         @RequestParam(defaultValue = "4") int size,
	                         Model model) {
	    Page<ClientDTO> clientDTOPage = clientService.getPaginatedClientDTOs(page, size);
	    model.addAttribute("clientPage", clientDTOPage);
	    return "clients"; // Thymeleaf template
	}
	
	@GetMapping("/clients/new")
	public String showClientForm(Model model) {
	    model.addAttribute("client", new ClientDTO());
	    return "client_form";
	}

	@PostMapping("/clients")
	public String addClient(@ModelAttribute("client") ClientDTO clientDTO, RedirectAttributes redirectAttributes) {
	    Client client = modelMapper.map(clientDTO, Client.class);
	    clientRepo.save(client);

	    redirectAttributes.addFlashAttribute("message", "New Client is added");
	    redirectAttributes.addFlashAttribute("messageType", "success");
	    return "redirect:/clients";
	}

	
	@GetMapping("/clients/edit/{id}")
	public String editClientForm(@PathVariable int id, Model model) {
	    Client client = clientRepo.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
	    ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);
	    model.addAttribute("client", clientDTO);
	    model.addAttribute("id", id);
	    return "client_form"; // reuse same form
	}

	@PostMapping("/clients/update/{id}")
	public String updateClient(@PathVariable int id,
	                           @ModelAttribute("client") ClientDTO clientDTO,
	                           RedirectAttributes redirectAttributes) {
	    Client client = clientRepo.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

	    client.setClientName(clientDTO.getClientName());
	    client.setClientAddress(clientDTO.getClientAddress());
	    client.setClientMobileNumber(clientDTO.getClientMobileNumber());
	    client.setClientAge(clientDTO.getClientAge());

	    clientRepo.save(client);

	    redirectAttributes.addFlashAttribute("message",
	            "Existing Client With Name: " + client.getClientName() + " is updated");
	    redirectAttributes.addFlashAttribute("messageType", "info");
	    return "redirect:/clients";
	}



	
	@PostMapping("/clients/delete/{id}")
	public String deleteClient(@PathVariable int id, RedirectAttributes redirectAttributes) {
	    clientRepo.deleteById(id);

	    redirectAttributes.addFlashAttribute("message", "Deleted a client");
	    redirectAttributes.addFlashAttribute("messageType", "error");
	    return "redirect:/clients";
	}






}
