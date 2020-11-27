package com.pim.blockchain.storage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pim.blockchain.storage.entity.Usuario;
import com.pim.blockchain.storage.enums.TipoUsuarioEnum;
import com.pim.blockchain.storage.repository.UsuarioRepository;

@SpringBootApplication
public class BlockchainStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockchainStorageApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		return args ->{
			initUsers( usuarioRepository, passwordEncoder );
		};
	}
	
	
	private void initUsers(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		Usuario usuario = new Usuario("admin@blockchainstorage.com", passwordEncoder.encode( "123456" ), TipoUsuarioEnum.ROLE_ADMIN, "Adriana Penha", "42717643734");
		
		Usuario usuarioBanco = usuarioRepository.findByEmail( usuario.getEmail() );
		if( usuarioBanco == null) {
			usuarioRepository.save( usuario );
		}else {
			usuario.setId( usuarioBanco.getId() );
			usuarioRepository.save( usuario );
		}
	}

}

