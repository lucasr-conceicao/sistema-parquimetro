package br.com.fiap.parquimetro.novo.adapters.rest.dto.condutor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CondutorResponseDto {

    private UUID condutorId;
    private String nome;
    private String telefone;
    private String email;
    private String formaPagamento;
}
