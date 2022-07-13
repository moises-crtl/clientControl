package com.example.demo.service;

import java.util.List;

import com.example.demo.model.clientModel;

public interface clientService {
	
	public List<clientModel> findAll();
	public clientModel findById(Long idClient);
	public clientModel delete(Long idClient);
	public clientModel update(clientModel clientModelRepository);

}
