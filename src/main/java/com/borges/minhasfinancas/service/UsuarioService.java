package com.borges.minhasfinancas.service;

import com.borges.minhasfinancas.model.entity.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);
    
    Usuario salvaUsuario(Usuario usuario);

    void validarEmail(String email);

}