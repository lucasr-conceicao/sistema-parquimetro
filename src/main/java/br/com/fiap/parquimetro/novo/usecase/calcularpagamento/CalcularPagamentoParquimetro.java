package br.com.fiap.parquimetro.novo.usecase.calcularpagamento;

import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.EstacionamentoResponse;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.IBuscarEstacionamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CalcularPagamentoParquimetro implements ICalcularPagamento {

    private final IBuscarEstacionamento buscarEstacionamento;

    @Override
    public CalcularPagamentoResponse calcularPagamento(UUID estacionamentoId) {
        var estacionamento = buscarEstacionamento.buscarEstacionamento(estacionamentoId);
        var valorEstacionamento = calcularValor(estacionamento);

        return CalcularPagamentoResponse.builder()
                .estacionamentoId(estacionamento.getEstacionamentoId())
                .veiculoId(estacionamento.getVeiculoId())
                .estacionamentoFixo(estacionamento.isEstacionamentoFixo())
                .valor(valorEstacionamento)
                .formaDePagamento(estacionamento.getFormaDePagamento())
                .horarioFim(estacionamento.getHorarioFim())
                .horarioInicio(estacionamento.getHorarioInicio())
                .estacionamentoFixo(estacionamento.isEstacionamentoFixo())
                .build();
    }

    private BigDecimal calcularValor(EstacionamentoResponse response) {
        BigDecimal tarifaBasePorHora = BigDecimal.valueOf(1);
        var duracao = Duration.between(response.getHorarioInicio(), response.getHorarioFim());

        if (response.isEstacionamentoFixo()) {
            return tarifaBasePorHora.multiply(BigDecimal.valueOf(duracao.toHours()));
        }
        return tarifaBasePorHora;
    }
}