package com.talesayajins.zello.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.talesayajins.zello.dto.PessoaDTO;
import com.talesayajins.zello.entities.Pessoa;
import com.talesayajins.zello.repositories.PessoaRepository;
import com.talesayajins.zello.services.exceptions.DataIntegrityException;
import com.talesayajins.zello.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	@Autowired
	private PerfilService perfilService;
	
	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
	}
	
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		System.out.println(obj.getCpf());
		System.out.println(obj.getNome());
		System.out.println(obj.getRg());
		System.out.println(obj.getDt_nascimento());
		return repo.save(obj);
	}
	
	public Pessoa update(Pessoa obj) {
		Pessoa newObj = find(obj.getId());
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
	
	public List<Pessoa> findAll() {
		return repo.findAll();
	}
	
	private void updateData(Pessoa newObj, Pessoa obj) {
		if(obj.getNome()!=null) {
			newObj.setNome(obj.getNome());
		}
		if(obj.getCpf()!=null) {
			newObj.setCpf(obj.getCpf());
		}
		if(obj.getRg()!=null) {
			newObj.setRg(obj.getRg());
		}
		if(obj.getDt_nascimento()!=null) {
			newObj.setDt_nascimento(obj.getDt_nascimento());
		}
		if(obj.getPerfil()!=null) {
			newObj.setPerfil(obj.getPerfil());
		}
	}
	
	public Pessoa fromDTO(PessoaDTO objDto) {
		Pessoa p = new Pessoa(null, 
				objDto.getNome(), 
				objDto.getCpf(), 
				objDto.getDt_nascimento(), 
				objDto.getRg(),
				objDto.getPerfil_id() != null ? perfilService.find(objDto.getPerfil_id()) : null
			);
		return p;
	}

}
