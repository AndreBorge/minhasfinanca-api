package com.borges.minhasfinancas.repository;

import com.borges.minhasfinancas.model.entity.Usuario;
import com.borges.minhasfinancas.model.repository.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveVerificarAExistenciaDeEmail(){

        //cenário
        Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
        repository.save(usuario);

        //ação

        boolean result = repository.existsByEmail("usuario@email.com");

        //verificação

        Assertions.assertThat(result).isTrue();

    }

}