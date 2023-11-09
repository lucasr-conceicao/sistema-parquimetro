package br.com.fiap.parquimetro.novo.adapters.rest.dto.estacionamento;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class EstacionamentoRequestDto {

    @JsonProperty("veiculo_id")
    private UUID veiculoId;

    @JsonProperty("horario_inicio")
    private LocalDateTime horarioInicio;

    @JsonProperty("horario_fim")
    private LocalDateTime horarioFim;

    @JsonProperty("valor")
    private BigDecimal valor;

    @JsonProperty("forma_pagamento")
    private Integer formaDePagamento;

    @JsonProperty("estacionamento_fixo")
    private boolean estacionamentoFixo;
}
