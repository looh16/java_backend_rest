package com.backend.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.backend.api.models.Categoria;
import com.backend.api.repositories.CategoriaRepository;
import com.backend.api.services.exceptions.DataIntegrityException;
import com.backend.api.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto nao encontrado! id " + id + ", tipo:" + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		
		find(obj.getId());
		
		return repo.save(obj);
	}

	public void delete(Integer id) {
		
		find(id);
		
		try {
			
		repo.deleteById(id);
		
			} 
			catch(DataIntegrityViolationException e) {
				
				throw new DataIntegrityException("Nao e possivel excluir uma categoria que tem produtos");
			}
	}

	public List<Categoria> findAll() {

		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
}





