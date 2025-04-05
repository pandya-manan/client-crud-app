package com.thymeleaf.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.thymeleaf.demo.repository.ClientRepository;
import com.thymeleaf.demo.entity.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
    private ModelMapper modelMapper;

	public Page<ClientDTO> getPaginatedClientDTOs(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size);
        Page<Client> clientPage = clientRepo.findAll(pageable);

        List<ClientDTO> dtoList = clientPage
            .getContent()
            .stream()
            .map(client -> modelMapper.map(client, ClientDTO.class))
            .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, clientPage.getTotalElements());
    }
	
	public void saveClientFromDTO(ClientDTO dto) {
	    Client client = modelMapper.map(dto, Client.class);
	    clientRepo.save(client);
	}

}
