package com.autobots.sistema.models;

import com.autobots.sistema.entities.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationModel {
	private String token;
	private Usuario user;
}