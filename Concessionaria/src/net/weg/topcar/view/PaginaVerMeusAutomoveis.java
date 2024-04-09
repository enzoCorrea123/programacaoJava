package net.weg.topcar.view;

import net.weg.topcar.controller.UsuarioController;
import net.weg.topcar.model.automoveis.Automovel;

import java.util.List;

public class PaginaVerMeusAutomoveis {
    private Saida saida;
    private UsuarioController usuarioController;
    public void verMeusAutomoveis(){
        List<Automovel> meusAutomoveis = usuarioController.verMeusAutomoveis();
        meusAutomoveis.forEach(automovel -> saida.escrevaln(automovel.toString()));
    }
}
