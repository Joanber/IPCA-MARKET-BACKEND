package com.example.IPCAMARKET.security.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.IPCAMARKET.models.Usuario;


@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {

//	  @Query(value ="SELECT u FROM Usuario u where u.nombre_usuario=:nombre_usuario") 
//          public Usuario findByNombre_usuario(@Param("nombre_usuario") String nombre_usuario);
	 
	
	Usuario findByUsername(String username);
	
        
        
	

}
