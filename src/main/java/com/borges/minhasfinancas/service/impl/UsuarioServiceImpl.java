package com.borges.minhasfinancas.service.impl;

import com.borges.minhasfinancas.exception.ErroAutenticacao;
import com.borges.minhasfinancas.exception.RegraNegocioException;
import com.borges.minhasfinancas.model.entity.Usuario;
import com.borges.minhasfinancas.model.repository.UsuarioRepository;
import com.borges.minhasfinancas.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        Optional<Usuario> usuario = repository.findByEmail(email);
        if(!usuario.isPresent()) {
        	throw new ErroAutenticacao("Usuario não encontrado para o email informado");
        }
        
        if(!usuario.get().getSenha().equals(senha)) {
        	throw new ErroAutenticacao("Senha invalida");
        }
        
        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario salvaUsuario(Usuario usuario) {
    	validarEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe){
            throw new RegraNegocioException("Já existe um usuário cadastrado com este email");
        }
    }

    

}