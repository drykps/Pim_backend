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
import com.pim.blockchain.storage.entity.Chave;
import com.pim.blockchain.storage.service.ChaveService;

@RestController
@RequestMapping("/chave")
public class ChaveController {

	@Autowired
	ChaveService chaveService;
	
	@PostMapping
	public ResponseEntity<Response<Chave>> incluirChave( HttpServletRequest request, @RequestBody Chave chave, BindingResult result ) throws Exception{
		Response<Chave> response = new Response<Chave>();
		
		if( result.hasErrors() ) {
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body( response );
			
		}
			
		Optional<Chave> chaveBanco = chaveService.incluirChave( chave );
		
		if(!chaveBanco.isPresent()) {
			return ResponseEntity.badRequest().body( response );
		}
		
		response.setData( chaveBanco.get() );
		
		return ResponseEntity.ok( response );
	}
	
	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Chave>> alterarChave( HttpServletRequest request, @RequestBody Chave chave, BindingResult result ){
		Response<Chave> response = new Response<Chave>();
		
		if( result.hasErrors() ) {
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body( response );
			
		}
			
		Optional<Chave> chaveBanco = chaveService.alterarChave(chave);
		
		if( !chaveBanco.isPresent() ) {
			return ResponseEntity.badRequest().body( response );
		}
		
		response.setData( chaveBanco.get() );
		
		return ResponseEntity.ok( response );
	}
	
	@DeleteMapping( value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Chave>> excluirChave(  @PathVariable("id") String id ){
		Response<Chave> response = new Response<Chave>();
		
		chaveService.excluirChave( Integer.parseInt(id) );
		
		return ResponseEntity.ok( response );
	}
	
	@GetMapping( value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Chave>> buscarChavePeloId( @PathVariable("id") String id){
		Response<Chave> response = new Response<Chave>();
		Optional<Chave> chave = chaveService.buscarChavePeloId(Integer.parseInt( id ));
		

		if( !chave.isPresent() ) {
			response.getErros().add("Chave não encontrada.");
			return ResponseEntity.badRequest().body( response );
			
		}
		
		response.setData( chave.get() );
		return ResponseEntity.ok( response );
	}
	
	@GetMapping( value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Page<Chave>>> buscarTodasChaves( @PathVariable int page, @PathVariable int count){
		Response<Page<Chave>> response = new Response<Page<Chave>>();
		
		Page<Chave> chaves = chaveService.buscarTodasChaves( page, count );
		System.out.println(chaves.getSize());
		response.setData( chaves );
		return ResponseEntity.ok( response );
	}

}
