package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    void setUp(){
        usuario = new Usuario("Fre", "Frederico");
    }

    @Test
    void constroi(){
        assertEquals("Fre", usuario.getApelido());
        assertEquals("Frederico", usuario.getNome());
    }

    @Test
    void mudaNome(){
        usuario.setNome("Eduardo");
        assertEquals("Fre", usuario.getApelido());
        assertEquals("Eduardo", usuario.getNome());
    }
}