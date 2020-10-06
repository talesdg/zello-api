package com.talesayajins.zello.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.talesayajins.zello.dto.PerfilDTO;
import com.talesayajins.zello.entities.Perfil;
import com.talesayajins.zello.services.PerfilService;

@CrossOrigin
@RestController
@RequestMapping(value="/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Perfil> find(@PathVariable Integer id) {
		Perfil obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PerfilDTO>> findAll() {
		List<Perfil> list = service.findAll();
		List<PerfilDTO> listDto = list.stream().map(obj -> new PerfilDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert( @RequestBody Perfil obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update( @RequestBody Perfil obj,@PathVariable Integer id){
//		Perfil obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
