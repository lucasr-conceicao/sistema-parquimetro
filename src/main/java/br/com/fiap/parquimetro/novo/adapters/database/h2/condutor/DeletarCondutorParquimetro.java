package br.com.fiap.parquimetro.novo.adapters.database.h2.condutor;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import br.com.fiap.parquimetro.novo.adapters.database.repository.CondutorRepository;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.IDeletarCondutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarCondutorParquimetro implements IDeletarCondutor {

    private final CondutorRepository condutorRepository;

    @Override
    @Transactional
    public void deletarCondutor(UUID condutorId) {
        var condutor = condutorRepository.findById(condutorId);
        var condutorValidado = validarCondutor(condutor);
        condutorRepository.deleteById(condutorValidado.get().getId());
    }

    private Optional<Condutor> validarCondutor(Optional<Condutor> response) {
        if (response.isEmpty())
            throw new AdapterException(("Registro nao encontrado"));
        return response;
    }
}
