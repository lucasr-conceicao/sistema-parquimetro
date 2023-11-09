package br.com.fiap.parquimetro.novo.adapters.database.h2.estacionamento;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Estacionamento;
import br.com.fiap.parquimetro.novo.adapters.database.domain.FormaPagamento;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Veiculo;
import br.com.fiap.parquimetro.novo.adapters.database.repository.EstacionamentoRepository;
import br.com.fiap.parquimetro.novo.adapters.database.repository.FormaPagamentoRepository;
import br.com.fiap.parquimetro.novo.adapters.database.repository.VeiculoRepository;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.EstacionamentoRequest;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.EstacionamentoResponse;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.IEstacionamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IniciarEstacionamento implements IEstacionamento {

    private final EstacionamentoRepository estacionamentoRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;
    private final VeiculoRepository veiculoRepository;

    @Override
    public EstacionamentoResponse iniciarEstacionamento(EstacionamentoRequest request) {
        validarEstacionamento(request);
        var estacionamento = montarRequest(request);
        estacionamentoRepository.save(estacionamento);
        return converterResponse(estacionamento);
    }

    private void validarEstacionamento(EstacionamentoRequest request){
        var formaDePagamento = buscarFormaPagamento(request.getFormaDePagamento());
        if (!"credito".equalsIgnoreCase(formaDePagamento.getDescricaoFormaPagamento()) && !"debito".equalsIgnoreCase(formaDePagamento.getDescricaoFormaPagamento())
                && !"pix".equalsIgnoreCase(formaDePagamento.getDescricaoFormaPagamento())) {
            throw new AdapterException("A forma de pagamento informada não é válida.");
        }

        boolean estacionamentoFixo = request.isEstacionamentoFixo();

        if ("pix".equalsIgnoreCase(formaDePagamento.getDescricaoFormaPagamento()) && !estacionamentoFixo) {
            throw new AdapterException("A opção PIX só está disponível para períodos de estacionamento fixos.");

        }
    }

    @Transactional(readOnly = true)
    private FormaPagamento buscarFormaPagamento(Integer formaPagamento) {
        return formaPagamentoRepository.findById(formaPagamento).orElseThrow(
                () -> new AdapterException("Não foi localizado registro."));
    }

    private Estacionamento montarRequest(EstacionamentoRequest request) {
        var veiculo = buscarVeiculo(request.getVeiculoId());
        return Estacionamento.builder()
                .id(UUID.randomUUID())
                .formaDePagamento(request.getFormaDePagamento())
                .valor(new BigDecimal(0))
                .horarioFim(request.getHorarioFim())
                .horarioInicio(request.getHorarioInicio())
                .veiculo(veiculo)
                .estacionamentoFixo(request.isEstacionamentoFixo())
                .build();
    }

    @Transactional(readOnly = true)
    private Veiculo buscarVeiculo(UUID veiculo) {
        return veiculoRepository.findById(veiculo).orElseThrow(
                () -> new AdapterException("Não foi localizado registro."));
    }

    private EstacionamentoResponse converterResponse(Estacionamento response) {
        return EstacionamentoResponse.builder()
                .estacionamentoId(response.getId())
                .veiculoId(response.getVeiculo().getId())
                .estacionamentoFixo(response.isEstacionamentoFixo())
                .valor(response.getValor())
                .formaDePagamento(response.getFormaDePagamento())
                .horarioFim(response.getHorarioFim())
                .horarioInicio(response.getHorarioInicio())
                .build();
    }
}
