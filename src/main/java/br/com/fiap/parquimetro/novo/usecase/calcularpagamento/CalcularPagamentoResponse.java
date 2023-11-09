package br.com.fiap.parquimetro.novo.usecase.calcularpagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalcularPagamentoResponse {

    private UUID estacionamentoId;
    private UUID veiculoId;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;
    private BigDecimal valor;
    private Integer formaDePagamento;
    private boolean estacionamentoFixo;
}
