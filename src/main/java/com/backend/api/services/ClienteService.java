package com.backend.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.backend.api.dto.ClienteDTO;
import com.backend.api.models.Cliente;
import com.backend.api.repositories.ClienteRepository;
import com.backend.api.services.exceptions.DataIntegrityException;
import com.backend.api.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto nao encontrado! id " + id + ", tipo:" + Cliente.class.getName()));
	}
	
//	public Cliente insert(Cliente obj) {
//		obj.setId(null);
//		return repo.save(obj);
//	}

	public Cliente update(Cliente obj) {
		
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		
		find(id);
		
		try {
			
		repo.deleteById(id);
		
			} 
			catch(DataIntegrityViolationException e) {
				
				throw new DataIntegrityException("Nao e possivel excluir porque ha entidades relacionadas");
			}
	}

	public List<Cliente> findAll() {

		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {

		newObj.setEmail(obj.getEmail());
		newObj.setName(obj.getName());
	}

}
