package br.com.fiap.parquimetro.novo.adapters.database.domain;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pagamento")
public class FormaPagamento {

    @Id
    @Column(name = "forma_pagamento_id")
    private Integer id;

    @Column(name = "descricao_forma_pagamento")
    private String descricaoFormaPagamento;

    @OneToMany(mappedBy = "formaPagamento")
    private List<Condutor> condutor;
}
