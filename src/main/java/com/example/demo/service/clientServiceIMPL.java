package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.clientModel;
import com.example.demo.repository.clientRepository;

@Service
public class clientServiceIMPL implements clientService {

	private clientRepository clientRepositoryImplementService;

	@Autowired
	public clientServiceIMPL(clientRepository clientRepositoryImplementService) {
		this.clientRepositoryImplementService = clientRepositoryImplementService;
	}

	@Override
	@Transactional(readOnly = true)
	public List<clientModel> findAll() {
		List<clientModel> clients = new ArrayList<>();
		clients = clientRepositoryImplementService.findAll();
		return clients;
	}

	@Override
	@Transactional(readOnly = true)
	public clientModel findById(Long idClient) {
		clientModel client = new clientModel();
		client = clientRepositoryImplementService.findById(idClient).orElse(null);
		if (client.getIdClient() == null) {
			return null;
		} else {
			return client;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public clientModel delete(Long idClient) {
		clientModel deleteClient = new clientModel();
		deleteClient = clientRepositoryImplementService.findById(idClient).orElse(null);
		if (deleteClient.getIdClient() == null) {
			return null;
		} else {
			deleteClient.setEstatus("Delete");
			return clientRepositoryImplementService.save(deleteClient);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public clientModel update(clientModel clientModelRepository) {
		clientModel updateClient = clientRepositoryImplementService.findById(clientModelRepository.getIdClient()).orElse(null);
		if (updateClient == null) {
			return null;
		} else {
			updateClient.setCodigo(clientModelRepository.getCodigo());
			updateClient.setNombre(clientModelRepository.getNombre());
			updateClient.setFecha(clientModelRepository.getFecha());
			updateClient.setSexo(clientModelRepository.getSexo());
			updateClient.setTelefono(clientModelRepository.getTelefono());
			updateClient.setCedula(clientModelRepository.getCedula());
			updateClient.setNumIdentificador(clientModelRepository.getNumIdentificador());
			updateClient.setCiudad(clientModelRepository.getCiudad());
			updateClient.setProvincia(clientModelRepository.getProvincia());
			updateClient.setBarrio(clientModelRepository.getBarrio());
			updateClient.setDireccion1(clientModelRepository.getDireccion1());
			updateClient.setDireccion2(clientModelRepository.getDireccion2());
			return clientRepositoryImplementService.save(updateClient);
		}		
	}

}
