package br.com.fiap.parquimetro.novo.usecase.database.estacionamento;

import java.util.UUID;

public interface IBuscarEstacionamento {

    EstacionamentoResponse buscarEstacionamento(UUID estacionamentoId);
}
