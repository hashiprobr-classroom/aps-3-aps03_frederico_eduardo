package br.edu.insper.desagil.aps3.vapor;

import java.util.List;

public class ComunidadeDeJogo extends Comunidade {

    private Jogo jogo;

    public ComunidadeDeJogo(List<Usuario> membros, Jogo jogo) {
        super(membros);
        this.jogo = jogo;
    }

    @Override
    public void adicionaMembro(Usuario usuario) {
        if (jogo.avaliado(usuario.getApelido())) {
            super.adicionaMembro(usuario);
        }
    }
}