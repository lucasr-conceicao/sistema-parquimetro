package br.com.fiap.parquimetro.novo.adapters.rest.dto.estacionamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstacionamentoResponseDto {

    private UUID estacionamentoId;
    private UUID veiculoId;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;
    private BigDecimal valor;
    private Integer formaDePagamento;
    private boolean estacionamentoFixo;
}
