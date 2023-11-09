package br.com.fiap.parquimetro.novo.usecase.database.condutor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CondutorRequest {

    private String nome;
    private String telefone;
    private String email;
    private Integer formaPagamento;
    private boolean horaFixa;
}
