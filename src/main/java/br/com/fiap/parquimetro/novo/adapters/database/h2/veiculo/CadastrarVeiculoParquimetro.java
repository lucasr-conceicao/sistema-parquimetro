package br.com.fiap.parquimetro.novo.adapters.database.h2.veiculo;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Veiculo;
import br.com.fiap.parquimetro.novo.adapters.database.repository.CondutorRepository;
import br.com.fiap.parquimetro.novo.adapters.database.repository.VeiculoRepository;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.ICadastrarVeiculo;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.VeiculoRequest;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.VeiculoResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarVeiculoParquimetro implements ICadastrarVeiculo {

    private final CondutorRepository condutorRepository;
    private final VeiculoRepository veiculoRepository;

    @Override
    public VeiculoResponse cadastrarVeiculo(VeiculoRequest request) {
        var veiculo = montarVeiculoRequest(request);
        veiculoRepository.save(veiculo);
        return converterResponse(veiculo);
    }

    private Veiculo montarVeiculoRequest(VeiculoRequest request) {
        var condutor = buscarCondutor(request.getCondutor());
        return Veiculo.builder()
                .condutor(condutor)
                .id(UUID.randomUUID())
                .marca(request.getMarca())
                .placa(request.getPlaca())
                .modelo(request.getModelo())
                .build();
    }

    @Transactional(readOnly = true)
    private Condutor buscarCondutor(UUID condutor) {
        return condutorRepository.findById(condutor).orElseThrow(
                () -> new AdapterException("Não foi localizado registro."));
    }

    private VeiculoResponse converterResponse(Veiculo veiculo) {
        return VeiculoResponse.builder()
                .condutor(veiculo.getCondutor().getId())
                .veiculoId(veiculo.getId())
                .marca(veiculo.getMarca())
                .placa(veiculo.getPlaca())
                .modelo(veiculo.getModelo())
                .build();
    }
}
