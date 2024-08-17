package com.email.proveider.application;

import org.springframework.stereotype.Service;

import com.email.proveider.adapters.UserGateway;
import com.email.proveider.core.UserUseCase;
import com.email.proveider.core.Entity.User;

@Service
public class UserService  implements UserUseCase{
	
	private final UserGateway gateway;
	
	public UserService(UserGateway gateWay) {	this.gateway  = gateWay;	}
	
		
	@Override
	public User salvarUser(Integer id, String nome, String idade) {
		return gateway.save(id, nome, idade);
	}

	@Override
	public User atualizar(Integer id, String nome, String idade) {
		return gateway.atualizar(id, nome, idade);
	}

	@Override
	public Iterable<User> listar() {
		return gateway.listar();
	}

	@Override
	public void deletar(Integer id) {
		gateway.deletar(id);
	}

}
