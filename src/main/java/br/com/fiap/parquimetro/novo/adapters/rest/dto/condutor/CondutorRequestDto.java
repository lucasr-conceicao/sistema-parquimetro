package br.com.fiap.parquimetro.novo.adapters.rest.dto.condutor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CondutorRequestDto {

    private String nome;
    private String telefone;
    private String email;
    @JsonProperty("forma_pagamento")
    private Integer formaPagamento;
    private boolean horaFixa;
}
