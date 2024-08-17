package com.email.proveider.core;

import com.email.proveider.core.Entity.User;

public interface UserUseCase {

	User salvarUser(Integer id, String nome, String idade);
	User atualizar(Integer id, String nome, String idade);
	Iterable<User> listar();
	void deletar(Integer id);
}
