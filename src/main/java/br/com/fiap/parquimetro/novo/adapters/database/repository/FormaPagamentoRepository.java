package br.com.fiap.parquimetro.novo.adapters.database.repository;

import br.com.fiap.parquimetro.novo.adapters.database.domain.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer> {
}
