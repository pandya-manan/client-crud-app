package com.thymeleaf.demo.service;

import org.springframework.data.domain.Page;

import com.thymeleaf.demo.entity.*;

public interface ClientService {

	Page<ClientDTO> getPaginatedClientDTOs(int page, int size);

	void saveClientFromDTO(ClientDTO clientDTO);

	
}
