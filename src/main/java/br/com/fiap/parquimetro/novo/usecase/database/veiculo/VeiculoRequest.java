package br.com.fiap.parquimetro.novo.usecase.database.veiculo;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class VeiculoRequest {

    private String placa;
    private String marca;
    private String modelo;
    private UUID condutor;
}
