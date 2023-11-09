package br.com.fiap.parquimetro.novo.usecase.database.veiculo;

import java.util.UUID;

public interface IBuscarVeiculo {

    VeiculoResponse buscarVeiculo(UUID veiculoId);
}
