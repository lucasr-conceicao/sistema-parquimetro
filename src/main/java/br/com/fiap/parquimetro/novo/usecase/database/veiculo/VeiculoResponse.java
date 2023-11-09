package br.com.fiap.parquimetro.novo.usecase.database.veiculo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoResponse {

    private UUID veiculoId;
    private String placa;
    private String marca;
    private String modelo;
    private UUID condutor;
}
