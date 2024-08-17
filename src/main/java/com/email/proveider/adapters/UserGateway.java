package com.email.proveider.adapters;

import com.email.proveider.core.Entity.User;

public interface UserGateway {

	User save(Integer id, String nome, String idade); 
	
	User atualizar(Integer id, String nome, String idade);

	Iterable<User> listar();

	void deletar(Integer id); 
		
	
}
