package com.email.proveider.infra;

import org.springframework.stereotype.Component;

import com.email.proveider.adapters.UserGateway;
import com.email.proveider.core.Entity.User;
import com.email.proveider.core.exceptions.ErroExclusaoException;

@Component
public class UserGatewayImpl implements UserGateway {

	private  UserRepository repository;
	
	UserGatewayImpl(UserRepository repository){
		this.repository = repository;
	}
	
	
	@Override
	public User save(Integer id, String nome, String idade) {
		var user = new User(nome, idade);
		return repository.save(user);
	}


	@Override
	public User atualizar(Integer id, String nome, String idade) {
		var user = repository.findById(id);
		user.get().setNome(nome);
		user.get().setIdade(idade);
		return repository.save(user.get());
	}


	@Override
	public Iterable<User> listar() {
		var listUser = repository.findAll();
		
		return listUser;
	}


	@Override
	public void deletar(Integer id) {
		 var busca = repository.findById(id);
		 if (busca.isEmpty()) {
			throw new ErroExclusaoException("Não encontrado itens para esse id");
		}
		repository.deleteById(id);
		
	}
	

}
