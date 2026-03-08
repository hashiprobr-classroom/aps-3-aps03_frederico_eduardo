package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LojaTest {
    private Loja loja;
    private Usuario dono;
    private Jogo jogo1;
    private Jogo jogo2;

    @BeforeEach
    void setUp(){
        dono = new Usuario("Fre", "Frederico");
        List<Jogo> jogos = new ArrayList<>();
        jogo1 = new Jogo(1,"Jogo1");
        jogo2 = new Jogo(2,"Jogo2");
        Jogo jogo3 = new Jogo(3,"Jogo3");
        jogos.add(jogo1);
        jogos.add(jogo2);
        jogos.add(jogo3);
        loja = new Loja(dono, jogos);
    }

    @Test
    void constroi(){
        assertEquals(dono, loja.getDono());
        assertEquals(0, loja.numeroAvaliados(dono));
    }

    @Test
    void umUsuarioAvaliaUmJogo(){
        jogo1.avalia(dono.getApelido(), 5);
        assertEquals(1, loja.numeroAvaliados(dono));
    }

    @Test
    void umUsuarioAvaliaDoisJogos(){
        jogo1.avalia(dono.getApelido(), 5);
        jogo2.avalia(dono.getApelido(), 5);
        assertEquals(2, loja.numeroAvaliados(dono));
    }

    @Test
    void doisUsuariosAvaliamUmJogo(){
        Usuario usuario = new Usuario("Edu", "Eduardo");
        jogo1.avalia(dono.getApelido(), 5);
        jogo1.avalia(usuario.getApelido(), 5);
        assertEquals(1, loja.numeroAvaliados(dono));
        assertEquals(1, loja.numeroAvaliados(usuario));
    }

    @Test
    void doisUsuariosAvaliamDoisJogos(){
        Usuario usuario = new Usuario("Edu", "Eduardo");
        jogo1.avalia(dono.getApelido(), 5);
        jogo2.avalia(usuario.getApelido(), 5);
        assertEquals(1, loja.numeroAvaliados(dono));
        assertEquals(1, loja.numeroAvaliados(usuario));
    }
}
