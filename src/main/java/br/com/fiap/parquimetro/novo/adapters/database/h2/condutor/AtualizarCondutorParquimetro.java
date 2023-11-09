package br.com.fiap.parquimetro.novo.adapters.database.h2.condutor;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import br.com.fiap.parquimetro.novo.adapters.database.domain.FormaPagamento;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Veiculo;
import br.com.fiap.parquimetro.novo.adapters.database.repository.CondutorRepository;
import br.com.fiap.parquimetro.novo.adapters.database.repository.FormaPagamentoRepository;
import br.com.fiap.parquimetro.novo.adapters.database.repository.VeiculoRepository;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.CondutorRequest;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.CondutorResponse;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.IAtualizarCondutor;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarCondutorParquimetro implements IAtualizarCondutor {

    private final CondutorRepository condutorRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;

    @Override
    public CondutorResponse atualizarCondutor(CondutorRequest request, UUID condutorId) {
        var condutor = montarCondutorRequest(request, condutorId);
        condutorRepository.save(condutor);
        return converterResponse(condutor);
    }

    private Condutor montarCondutorRequest(CondutorRequest request, UUID condutorId) {
        var condutor = buscarCondutor(condutorId);
        var formaPagamento = buscarFormaPagamento(request.getFormaPagamento());
        condutor.setFormaPagamento(formaPagamento);
        return condutor;
    }

    @Transactional(readOnly = true)
    private Condutor buscarCondutor(UUID condutorId) {
        return condutorRepository.findById(condutorId).orElseThrow(
                () -> new AdapterException("Não foi localizado registro."));
    }

    @Transactional(readOnly = true)
    private FormaPagamento buscarFormaPagamento(Integer formaPagamento) {
        return formaPagamentoRepository.findById(formaPagamento).orElseThrow(
                () -> new AdapterException("Não foi localizado registro."));
    }

    private CondutorResponse converterResponse(Condutor condutor) {
        return CondutorResponse.builder()
                .condutorId(condutor.getId())
                .nome(condutor.getNome())
                .email(condutor.getEmail())
                .telefone(condutor.getTelefone())
                .formaPagamento(condutor.getFormaPagamento().getDescricaoFormaPagamento())
                .build();
    }
}
