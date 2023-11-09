package br.com.fiap.parquimetro.novo.adapters.database.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_condutor")
public class Condutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty(message = "Nome do condutor é obrigatório.")
    private String nome;

    @NotEmpty(message = "Telefone do condutor é obrigatório.")
    private String telefone;

    @NotEmpty(message = "E-mail do condutor é obrigatório.")
    @Email(message = "O e-mail deve ser informado em um formato válido.")
    private String email;

    @OneToMany(mappedBy = "condutor", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id")
    private FormaPagamento formaPagamento;
}