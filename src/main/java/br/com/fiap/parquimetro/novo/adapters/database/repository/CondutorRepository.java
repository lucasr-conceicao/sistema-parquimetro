package br.com.fiap.parquimetro.novo.adapters.database.repository;

import br.com.fiap.parquimetro.novo.adapters.database.domain.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CondutorRepository extends JpaRepository<Condutor, UUID> {
}
