package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComunidadeTest {
    private Comunidade comunidade;

    @BeforeEach
    void setUp(){
        Usuario usuario1 = new Usuario("Fre", "Frederico");
        Usuario usuario2 = new Usuario("Edu", "Eduardo");
        List<Usuario> membros = new ArrayList<>(List.of(usuario1, usuario2));
        comunidade = new Comunidade(membros);
    }

    @Test
    void constroi(){
        List<String> apelidos = List.of("Fre", "Edu");
        assertEquals(apelidos, comunidade.apelidosMembros());
    }

    @Test
    void adicionaUmMembro(){
        Usuario usuario3 = new Usuario("Ique", "Henrique");
        comunidade.adicionaMembro(usuario3);
        List<String> apelidos = List.of("Fre", "Edu", "Ique");
        assertEquals(apelidos, comunidade.apelidosMembros());
    }

    @Test
    void adicionaDoisMembros(){
        Usuario usuario3 = new Usuario("Ique", "Henrique");
        Usuario usuario4 = new Usuario("Fe", "Felipe");
        comunidade.adicionaMembro(usuario3);
        comunidade.adicionaMembro(usuario4);
        List<String> apelidos = List.of("Fre", "Edu", "Ique", "Fe");
        assertEquals(apelidos, comunidade.apelidosMembros());
    }
}
