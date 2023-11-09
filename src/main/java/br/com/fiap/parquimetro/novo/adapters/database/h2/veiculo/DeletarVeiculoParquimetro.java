package br.com.fiap.parquimetro.novo.adapters.database.h2.veiculo;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Veiculo;
import br.com.fiap.parquimetro.novo.adapters.database.repository.VeiculoRepository;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.IDeletarVeiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletarVeiculoParquimetro implements IDeletarVeiculo {

    private final VeiculoRepository veiculoRepository;

    @Override
    public void deletarVeiculo(UUID veiculoId) {
        var veiculo = veiculoRepository.findById(veiculoId);
        var veiculoValidado = validarVeiculo(veiculo);
        veiculoRepository.deleteById(veiculoValidado.get().getId());
    }

    private Optional<Veiculo> validarVeiculo(Optional<Veiculo> response) {
        if (response.isEmpty())
            throw new AdapterException((""));
        return response;
    }
}
