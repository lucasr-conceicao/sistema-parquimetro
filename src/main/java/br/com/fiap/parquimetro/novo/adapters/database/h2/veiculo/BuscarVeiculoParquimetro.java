package br.com.fiap.parquimetro.novo.adapters.database.h2.veiculo;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import br.com.fiap.parquimetro.novo.adapters.database.domain.Veiculo;
import br.com.fiap.parquimetro.novo.adapters.database.repository.VeiculoRepository;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.IBuscarVeiculo;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.VeiculoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscarVeiculoParquimetro implements IBuscarVeiculo {

    private final VeiculoRepository veiculoRepository;

    @Override
    public VeiculoResponse buscarVeiculo(UUID veiculoId) {
        var veiculo = veiculoRepository.findById(veiculoId);
        var veiculoValidado = validarVeiculo(veiculo);
        return converterResponse(veiculoValidado);
    }

    private Optional<Veiculo> validarVeiculo(Optional<Veiculo> response) {
        if (response.isEmpty())
            throw new AdapterException(("Registro nao encontrado"));
        return response;
    }

    private VeiculoResponse converterResponse(Optional<Veiculo> response) {
        return VeiculoResponse.builder()
                .veiculoId(response.get().getId())
                .placa(response.get().getPlaca())
                .marca(response.get().getMarca())
                .modelo(response.get().getModelo())
                .condutor(response.get().getCondutor().getId())
                .build();
    }
}
