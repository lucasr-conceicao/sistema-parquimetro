package br.com.fiap.parquimetro.novo.usecase.database.estacionamento;

public interface IEstacionamento {
    EstacionamentoResponse iniciarEstacionamento(EstacionamentoRequest request);
}
