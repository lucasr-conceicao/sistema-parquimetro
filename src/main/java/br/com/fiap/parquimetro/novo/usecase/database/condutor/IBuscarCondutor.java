package br.com.fiap.parquimetro.novo.usecase.database.condutor;

import java.util.UUID;

public interface IBuscarCondutor {

    CondutorResponse buscarCondutor(UUID condutorId);
}
