package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComunidadeDeJogoTest {
    private ComunidadeDeJogo comunidade_de_jogo;
    private Usuario usuario1;
    private Usuario usuario2;
    private Jogo jogo;

    @BeforeEach
    void setUp(){
        usuario1 = new Usuario("Fre", "Frederico");
        usuario2 = new Usuario("Edu", "Eduardo");
        List<Usuario> membros = new ArrayList<>();
        jogo = new Jogo(1, "Jogo1");
        comunidade_de_jogo = new ComunidadeDeJogo(membros, jogo);
    }

    @Test
    void adicionaDoisInvalidos(){
        comunidade_de_jogo.adicionaMembro(usuario1);
        comunidade_de_jogo.adicionaMembro(usuario2);
        List<String> apelidos = new ArrayList<>();
        assertEquals(apelidos, comunidade_de_jogo.apelidosMembros());
    }

    @Test
    void adicionaUmInvalidoUmValido(){
        jogo.avalia(usuario1.getApelido(), 5);
        comunidade_de_jogo.adicionaMembro(usuario1);
        comunidade_de_jogo.adicionaMembro(usuario2);
        List<String> apelidos = new ArrayList<>(List.of(usuario1.getApelido()));
        assertEquals(apelidos, comunidade_de_jogo.apelidosMembros());
    }

    @Test
    void adicionaDoisValidos(){
        jogo.avalia(usuario1.getApelido(), 5);
        jogo.avalia(usuario2.getApelido(), 5);
        comunidade_de_jogo.adicionaMembro(usuario1);
        comunidade_de_jogo.adicionaMembro(usuario2);
        List<String> apelidos = new ArrayList<>(List.of(usuario1.getApelido(), usuario2.getApelido()));
        assertEquals(apelidos, comunidade_de_jogo.apelidosMembros());
    }
}
