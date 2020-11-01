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
import com.pim.blockchain.storage.entity.Categoria;
import com.pim.blockchain.storage.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Categoria>> incluirCategoria( HttpServletRequest request, @RequestBody Categoria categoria, BindingResult result ){
		Response<Categoria> response = new Response<Categoria>();
		
		if( result.hasErrors() ) {
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body( response );
			
		}
			
		Optional<Categoria> categoriaBanco = categoriaService.incluirCategoria( categoria );
		
		if( !categoriaBanco.isPresent() ) {
			return ResponseEntity.badRequest().body( response );
		};
		
		response.setData( categoriaBanco.get() );
		return ResponseEntity.ok( response );
	}
	
	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Categoria>> alterarCategoria( HttpServletRequest request, @RequestBody Categoria categoria, BindingResult result ){
		Response<Categoria> response = new Response<Categoria>();
		
		if( result.hasErrors() ) {
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body( response );
			
		}
			
		Optional<Categoria> categoriaBanco = categoriaService.alterarCategoria(categoria);
		
		if( !categoriaBanco.isPresent() ) {
			return ResponseEntity.badRequest().body( response );
		};
		
		response.setData( categoriaBanco.get() );
		
		return ResponseEntity.ok( response );
	}
	
	@DeleteMapping( value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Categoria>> excluirCategoria(  @PathVariable("id") String id ){
		Response<Categoria> response = new Response<Categoria>();
		
		categoriaService.excluirCategoria( Integer.parseInt(id) );
		
		return ResponseEntity.ok( response );
	}
	
	@GetMapping( value = "{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Categoria>> buscarCategoriaPeloId( @PathVariable("id") String id){
		Response<Categoria> response = new Response<Categoria>();
		Optional<Categoria> categoria = categoriaService.buscarCategoriaPeloId(Integer.parseInt( id ));
		

		if( !categoria.isPresent() ) {
			response.getErros().add("Categoria não encontrada.");
			return ResponseEntity.badRequest().body( response );
			
		}
		
		response.setData( categoria.get() );
		return ResponseEntity.ok( response );
	}
	
	@GetMapping( value = "{page}/{count}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<Page<Categoria>>> buscarTodasCategorias( @PathVariable int page, @PathVariable int count){
		Response<Page<Categoria>> response = new Response<Page<Categoria>>();
		
		Page<Categoria> categorias = categoriaService.buscarTodasCategorias( page, count );
		response.setData( categorias );
		return ResponseEntity.ok( response );
	}

}
