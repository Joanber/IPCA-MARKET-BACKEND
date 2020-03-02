package com.example.IPCAMARKET.security.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.IPCAMARKET.models.Usuario;
import com.example.IPCAMARKET.security.pojos.UserQuery;


@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {


	 
	
	Usuario findByUsername(String username);
	
	@Query(value = "SELECT u.id_usuario AS id,\r\n" + 
			"u.username AS username,\r\n" + 
			"u.id_rol AS rol,\r\n" + 
			"u.id_persona AS persona\r\n" + 
			"from \"public\".usuario u join rol r on u.id_rol=r.id_rol\r\n" + 
			"join persona p on u.id_persona=p.id_persona\r\n" + 
			"WHERE u.username= :username", nativeQuery = true)
	UserQuery buscarPorUsername(@Param("username") String username);
	
        
        
	

}
