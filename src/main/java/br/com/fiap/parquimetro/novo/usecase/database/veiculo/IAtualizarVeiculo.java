package br.com.fiap.parquimetro.novo.usecase.database.veiculo;

import java.util.UUID;

public interface IAtualizarVeiculo {

    VeiculoResponse atualizarVeiculo(VeiculoRequest request, UUID veiculoId);
}
