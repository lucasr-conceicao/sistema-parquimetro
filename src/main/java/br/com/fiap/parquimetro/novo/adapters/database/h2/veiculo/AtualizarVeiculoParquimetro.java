package br.com.fiap.parquimetro.novo.adapters.database.h2.veiculo;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Veiculo;
import br.com.fiap.parquimetro.novo.adapters.database.repository.CondutorRepository;
import br.com.fiap.parquimetro.novo.adapters.database.repository.VeiculoRepository;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.IAtualizarVeiculo;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.VeiculoRequest;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.VeiculoResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AtualizarVeiculoParquimetro implements IAtualizarVeiculo {

    private final VeiculoRepository veiculoRepository;
    private final CondutorRepository condutorRepository;

    @Override
    public VeiculoResponse atualizarVeiculo(VeiculoRequest request, UUID veiculoId) {
        var veiculo = montarVeiculoRequest(request, veiculoId);
        veiculoRepository.save(veiculo);
        return converterResponse(veiculo);
    }

    private Veiculo montarVeiculoRequest(VeiculoRequest request, UUID veiculoId) {
        var veiculo = buscarVeiculo(veiculoId);
        var condutor = buscarCondutor(request.getCondutor());

        return Veiculo.builder()
                .id(veiculo.getId())
                .placa(request.getPlaca())
                .modelo(request.getModelo())
                .marca(request.getMarca())
                .condutor(condutor)
                .build();
    }

    @Transactional(readOnly = true)
    private Veiculo buscarVeiculo(UUID veiculoId) {
        return veiculoRepository.findById(veiculoId).orElseThrow(
                () -> new AdapterException("Não foi localizado registro."));
    }

    @Transactional(readOnly = true)
    private Condutor buscarCondutor(UUID condutorId) {
        return condutorRepository.findById(condutorId).orElseThrow(
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
