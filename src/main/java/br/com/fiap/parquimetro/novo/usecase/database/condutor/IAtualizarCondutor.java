package br.com.fiap.parquimetro.novo.usecase.database.condutor;

import java.util.UUID;

public interface IAtualizarCondutor {

    CondutorResponse atualizarCondutor(CondutorRequest request, UUID condutorId);
}
