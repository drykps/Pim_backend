package com.pim.blockchain.storage.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pim.blockchain.storage.api.Response;
import com.pim.blockchain.storage.entity.Endereco;
import com.pim.blockchain.storage.service.EnderecoService;

@RestController()
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<Response<Endereco>> incluirEndereco( HttpServletRequest request, @RequestBody Endereco endereco, BindingResult result ){
		Response<Endereco> response = new Response<Endereco>();
		
		if( result.hasErrors() ) {
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body( response );
			
		}
			
		Optional<Endereco> enderecoBanco = enderecoService.incluirEndereco( endereco );
		
		if( !enderecoBanco.isPresent() ) {
			return ResponseEntity.badRequest().body( response );
		}
			
		response.setData( enderecoBanco.get() );
		
		return ResponseEntity.ok( response );
	}
	
	@PutMapping
	public ResponseEntity<Response<Endereco>> alterar( HttpServletRequest request, @RequestBody Endereco endereco, BindingResult result ){
		Response<Endereco> response = new Response<Endereco>();
		
		if( result.hasErrors() ) {
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body( response );
			
		}
			
		Optional<Endereco> enderecoBanco = enderecoService.alterarEndereco(endereco);
		
		if( !enderecoBanco.isPresent() ) {
			return ResponseEntity.badRequest().body( response );
		}
			
		response.setData( enderecoBanco.get() );
		
		return ResponseEntity.ok( response );
	}
	
	@DeleteMapping( value = "{id}")
	public ResponseEntity<Response<Endereco>> excluirEndereco(  @PathVariable("id") String id ){
		Response<Endereco> response = new Response<Endereco>();
		
		enderecoService.excluirEndereco( Integer.parseInt(id) );
		
		return ResponseEntity.ok( response );
	}
	
	@GetMapping( value = "{id}")
	public ResponseEntity<Response<Endereco>> buscarEnderecoPeloId( @PathVariable("id") String id){
		Response<Endereco> response = new Response<Endereco>();
		Optional<Endereco> endereco = enderecoService.buscarEnderecoPeloId(Integer.parseInt( id ));
		

		if( !endereco.isPresent() ) {
			response.getErros().add("Endereco não encontrada.");
			return ResponseEntity.badRequest().body( response );
			
		}
		
		response.setData( endereco.get() );
		return ResponseEntity.ok( response );
	}
	
	@GetMapping( value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Page<Endereco>>> buscarTodasEnderecos( @PathVariable int page, @PathVariable int count){
		Response<Page<Endereco>> response = new Response<Page<Endereco>>();
		
		Page<Endereco> enderecos = enderecoService.buscarTodasEnderecos( page, count );
		response.setData( enderecos );
		return ResponseEntity.ok( response );
	}

}
