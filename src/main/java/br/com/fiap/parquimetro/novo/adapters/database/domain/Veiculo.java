package br.com.fiap.parquimetro.novo.adapters.database.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "A placa do veículo deve ser informada.")
    private String placa;

    @NotBlank(message = "A marca do veículo deve ser informada.")
    private String marca;

    @NotBlank(message = "O modelo do veículo deve ser informado.")
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "condutor_id", nullable = false)
    private Condutor condutor;
}



