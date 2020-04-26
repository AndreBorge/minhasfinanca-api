package com.borges.minhasfinancas.model.repository;


import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.borges.minhasfinancas.model.entity.Usuario;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;
    
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void deveVerificarAExistenciaDeEmail(){

        //cenário
        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);
        
        //ação
        boolean result = repository.existsByEmail("usuario@email.com");

        //verificação
        Assertions.assertThat(result).isTrue();

    }
    
   @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
    	//cenario
    	
	   
    	//ação
    	boolean result = repository.existsByEmail("usuario@email.com");
    	
    	//verificação
    	Assertions.assertThat(result).isFalse();
    }
   
   @Test
   public void devePersistieUsuarioNaBaseDeDados() {
	   //cenario
	   Usuario usuario = criarUsuario();
	
	   //ação
	   Usuario usuarioSalvo = repository.save(usuario);
	   
	   //verificação
	   Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
   }
   
   @Test
   public void deveBuscarUmUsuarioPorEmail() {
	   //cenario
	   Usuario usuario = criarUsuario();
	   entityManager.persist(usuario);
	   
	   //ação
	   Optional<Usuario> result = repository.findByEmail("usuario@email.com");
	   
	   //verificação
	   Assertions.assertThat(result.isPresent()).isTrue();
	   
	  
   }
   
   @Test
   public void deveRetornarVazioUsuarioPorEmail() {
	   
	   //ação
	   Optional<Usuario> result = repository.findByEmail("usuario@email.com");
	   
	   //verificação
	   Assertions.assertThat(result.isPresent()).isFalse();
	   
	  
   }
   
   public static Usuario criarUsuario() {
	   Usuario usuario = Usuario
			   .builder()
			   .nome("usuario")
			   .email("usuario@email.com")
			   .senha("senha")
			   .build();
	   return usuario;
   }

}