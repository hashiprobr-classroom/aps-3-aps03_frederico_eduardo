package br.edu.insper.desagil.aps3.vapor;

import java.util.List;
import java.util.ArrayList;

public class Comunidade {
    private List<Usuario> membros;

    public Comunidade(List<Usuario> membros) {
        this.membros = membros;
    }

    public void adicionaMembro(Usuario usuario) {
        membros.add(usuario);
    }

    public List<String> apelidosMembros() {
        List<String> membros_apelido = new ArrayList<>();

        for (Usuario usuario : membros) {
            String apelido = usuario.getApelido();
            membros_apelido.add(apelido);
        }

        return membros_apelido;
    }

}
