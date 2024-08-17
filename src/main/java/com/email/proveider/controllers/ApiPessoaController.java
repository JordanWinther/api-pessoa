package com.email.proveider.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.proveider.core.UserUseCase;
import com.email.proveider.core.Entity.User;
import com.email.proveider.core.exceptions.ErroExclusaoException;

@CrossOrigin(origins = "*")
@RestController
public class ApiPessoaController {
	
	private final UserUseCase senderUseCase;
	
	 public ApiPessoaController(  UserUseCase senderUseCase ) {
		this.senderUseCase = senderUseCase;
	}

	@PostMapping()
	public ResponseEntity<Object> saveUser( @RequestBody  User user){
				  var userResponse = senderUseCase.salvarUser(user.getId() , user.getNome(), user.getIdade() );
				  System.out.println("Usuário adicionado");
				  return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
		}
	
	@GetMapping()
	public ResponseEntity<Iterable<User>> listar(){
		
			  var listUserResponse = senderUseCase.listar();
			return  ResponseEntity.ok(listUserResponse);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Integer id){
		try {
			 senderUseCase.deletar(id);
			 return  ResponseEntity.noContent().build();
		} catch (ErroExclusaoException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@PutMapping()
	public ResponseEntity<Object> atualizar(@RequestBody  User user){
		try {
			  var userResponse = senderUseCase.atualizar(user.getId() , user.getNome(), user.getIdade() );
			  System.out.println("Usuário editado");
			return  ResponseEntity.ok(userResponse);
		} catch (ErroExclusaoException e) {
			return ResponseEntity.ok(new ErroExclusaoException("Error while saving user", e.getCause()) );
		}
	}
	
	
}
