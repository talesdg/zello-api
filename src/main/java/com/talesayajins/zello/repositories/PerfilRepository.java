package com.talesayajins.zello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talesayajins.zello.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

}
