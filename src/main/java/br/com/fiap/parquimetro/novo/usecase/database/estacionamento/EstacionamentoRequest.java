package br.com.fiap.parquimetro.novo.usecase.database.estacionamento;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class EstacionamentoRequest {

    private UUID veiculoId;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;
    private BigDecimal valor;
    private Integer formaDePagamento;
    private boolean estacionamentoFixo;
}
