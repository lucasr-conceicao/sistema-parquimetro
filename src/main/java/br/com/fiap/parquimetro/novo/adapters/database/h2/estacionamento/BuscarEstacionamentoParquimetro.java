package br.com.fiap.parquimetro.novo.adapters.database.h2.estacionamento;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Estacionamento;
import br.com.fiap.parquimetro.novo.adapters.database.repository.EstacionamentoRepository;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.EstacionamentoResponse;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.IBuscarEstacionamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarEstacionamentoParquimetro implements IBuscarEstacionamento {

    private final EstacionamentoRepository estacionamentoRepository;

    @Override
    public EstacionamentoResponse buscarEstacionamento(UUID estacionamentoId) {
        var estacionamento = estacionamentoRepository.findById(estacionamentoId);
        var estacionamentoValidado = validarEstacionamento(estacionamento);
        return converterResponse(estacionamentoValidado);
    }

    private Optional<Estacionamento> validarEstacionamento(Optional<Estacionamento> response) {
        if (response.isEmpty())
            throw new AdapterException(("Estacionamento nao encontrado"));
        return response;
    }

    private EstacionamentoResponse converterResponse(Optional<Estacionamento> response) {
        return EstacionamentoResponse.builder()
                .estacionamentoId(response.get().getId())
                .veiculoId(response.get().getVeiculo().getId())
                .estacionamentoFixo(response.get().isEstacionamentoFixo())
                .valor(response.get().getValor())
                .formaDePagamento(response.get().getFormaDePagamento())
                .horarioFim(response.get().getHorarioFim())
                .horarioInicio(response.get().getHorarioInicio())
                .build();
    }
}
