package br.com.fiap.parquimetro.novo.adapters.database.repository;

import br.com.fiap.parquimetro.novo.adapters.database.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
}
