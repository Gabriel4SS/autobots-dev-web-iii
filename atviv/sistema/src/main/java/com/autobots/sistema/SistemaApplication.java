package com.autobots.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.enums.TipoUser;
import com.autobots.sistema.models.AuthenticationModel;
import com.autobots.sistema.repositories.UsuarioRepository;
import com.autobots.sistema.services.JwtService;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void run(String... args) throws Exception {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		final String secret = "secreta";
		final long duration = 9000000;


		Usuario usuario = new Usuario();
		usuario.setNome("caio");
		usuario.setUserEmail("caio@gmail.com");
		usuario.setSenha(passwordEncoder.encode("senha"));
		usuario.setTipoUser(TipoUser.CLIENTE);
		usuario.setCargo("ADMINISTRADOR");
		String jwtToken = jwtService.createToken(usuario.getUserEmail(), duration, secret);
		jwtToken = "Bearear " + jwtToken;
		AuthenticationModel userToken = new AuthenticationModel(jwtToken, usuario);
		//authenticationManager.authenticate(userToken);
		usuarioRepository.save(usuario);
	}

}


