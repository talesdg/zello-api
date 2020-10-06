package com.talesayajins.zello.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.talesayajins.zello.entities.Perfil;
import com.talesayajins.zello.repositories.PerfilRepository;
import com.talesayajins.zello.services.exceptions.DataIntegrityException;
import com.talesayajins.zello.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository repo;
	
	public Perfil find(Integer id) {
		Optional<Perfil> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Perfil.class.getName()));
	}
	
	public Perfil insert(Perfil obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Perfil update(Perfil obj) {
		Perfil newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas.");
		}
	}
	
	public List<Perfil> findAll() {
		return repo.findAll();
	}
	
	private void updateData(Perfil newObj, Perfil obj) {
		newObj.setNome(obj.getNome());
	}

}
