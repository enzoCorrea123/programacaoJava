package Usuarios;

import Veiculos.Veiculo;

import java.util.List;

public interface IUsuario {
    List<Veiculo> verVeiculos();
    List<Veiculo> verMeusVeiculos();
    Veiculo verVeiculo(int codigo);

}
