package br.com.fiap.parquimetro.novo.adapters.rest.dto.veiculo;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class VeiculoRequestDto {

    private String placa;
    private String marca;
    private String modelo;
    private UUID condutor;
}
