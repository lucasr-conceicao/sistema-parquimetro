package br.com.fiap.parquimetro.novo.adapters.database.h2.condutor;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import br.com.fiap.parquimetro.novo.adapters.database.domain.FormaPagamento;
import br.com.fiap.parquimetro.novo.adapters.database.repository.CondutorRepository;
import br.com.fiap.parquimetro.novo.adapters.database.repository.FormaPagamentoRepository;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.CondutorRequest;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.CondutorResponse;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.ICadastrarCondutor;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarCondutorParquimetro implements ICadastrarCondutor {

    private final CondutorRepository condutorRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;

    @Override
    @Transactional
    public CondutorResponse cadastrarCondutor(CondutorRequest request) {
        var condutor = montarCondutorRequest(request);
        condutorRepository.save(condutor);
        return converterResponse(condutor);
    }

    private Condutor montarCondutorRequest(CondutorRequest request) {
        var formaPagamento = buscarFormaPagamento(request.getFormaPagamento());
        return Condutor.builder()
                .id(UUID.randomUUID())
                .nome(request.getNome())
                .email(request.getEmail())
                .telefone(request.getTelefone())
                .formaPagamento(formaPagamento)
                .build();
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
