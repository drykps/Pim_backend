package com.pim.blockchain.storage.security.jwt;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pim.blockchain.storage.api.Response;
import com.pim.blockchain.storage.entity.Usuario;
import com.pim.blockchain.storage.security.model.CurrentUser;
import com.pim.blockchain.storage.service.UsuarioService;

@RestController
@CrossOrigin( origins = "*" )
public class AuthenticationRestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping( value="/api/auth" )
	public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtAuthenticationRequest authenticationRequest ) {
		Response<JwtAuthenticationRequest> response = new Response<JwtAuthenticationRequest>();
		try {
			final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authenticationRequest.getEmail(),
							authenticationRequest.getPassword()
							)
					);
			SecurityContextHolder.getContext().setAuthentication( authentication );
			final UserDetails userDetails = userDetailsService.loadUserByUsername( authenticationRequest.getEmail() );
			final String token = jwtTokenUtil.generateToken( userDetails );
			
			final Optional<Usuario> usuario = usuarioService.buscarUsuarioPorEmail( authenticationRequest.getEmail() );
			usuario.get().setSenha( null );
			
			return ResponseEntity.ok( new CurrentUser( token, usuario.get() ) );
		}catch(BadCredentialsException e) {
			response.getErros().add("Email e/ou senha estão incorretos!");
		}
		
		return ResponseEntity.ok().body(response);
		
	}
	
	@PostMapping( value="/api/refresh" )
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request){
		String token = request.getHeader( "Authorization" );
		String username = jwtTokenUtil.getUsernameFromToken( token );
		final Optional<Usuario> usuario = usuarioService.buscarUsuarioPorEmail( username );
		
		if( jwtTokenUtil.canTokenBeRefreshed( token ) ) {
			String refreshedToken = jwtTokenUtil.refreshToken( token );
			return ResponseEntity.ok( new CurrentUser( refreshedToken, usuario.get() ) );
		}
		
		return ResponseEntity.badRequest().body( null );
		
	}
	
	
}
