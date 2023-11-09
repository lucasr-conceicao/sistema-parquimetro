package br.com.fiap.parquimetro.novo.adapters.database.h2.condutor;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import br.com.fiap.parquimetro.novo.adapters.database.repository.CondutorRepository;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.CondutorResponse;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.IBuscarCondutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarCondutorParquimetro implements IBuscarCondutor {

    private final CondutorRepository condutorRepository;

    @Override
    public CondutorResponse buscarCondutor(UUID condutorId) {
        var condutor = condutorRepository.findById(condutorId);
        var condutorValidado = validarCondutor(condutor);
        return converterResponse(condutorValidado);
    }

    private Optional<Condutor> validarCondutor(Optional<Condutor> response) {
        if (response.isEmpty())
            throw new AdapterException(("Condutor nao encontrado"));
        return response;
    }

    private CondutorResponse converterResponse(Optional<Condutor> response) {
        return CondutorResponse.builder()
                .condutorId(response.get().getId())
                .nome(response.get().getNome())
                .email(response.get().getEmail())
                .telefone(response.get().getTelefone())
                .formaPagamento(response.get().getFormaPagamento().getDescricaoFormaPagamento())
                .build();
    }
}
