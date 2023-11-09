package br.com.fiap.parquimetro.novo.usecase.database.estacionamento;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstacionamentoResponse {

    private UUID estacionamentoId;
    private UUID veiculoId;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;
    private BigDecimal valor;
    private Integer formaDePagamento;
    private boolean estacionamentoFixo;
}
