package br.com.fiap.parquimetro.novo.usecase.calcularpagamento;

import java.util.UUID;

public interface ICalcularPagamento {

    CalcularPagamentoResponse calcularPagamento(UUID estacionamentoId);
}
