package br.com.fiap.parquimetro.novo.adapters.database.repository;

import br.com.fiap.parquimetro.novo.adapters.database.domain.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, UUID> {
}
