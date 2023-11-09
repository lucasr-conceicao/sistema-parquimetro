package br.com.fiap.parquimetro.novo.adapters.rest.controller;

import br.com.fiap.parquimetro.novo.adapters.rest.dto.condutor.CondutorRequestDto;
import br.com.fiap.parquimetro.novo.adapters.rest.dto.condutor.CondutorResponseDto;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/condutor")
public class CondutorController {

    private final ICadastrarCondutor cadastrarCondutor;
    private final IBuscarCondutor buscarCondutor;
    private final IAtualizarCondutor atualizarCondutor;
    private final IDeletarCondutor deletarCondutor;

    @PostMapping
    public ResponseEntity<CondutorResponseDto> cadastrarCondutor(@Valid @RequestBody CondutorRequestDto requestDto) {
        var response = cadastrarCondutor.cadastrarCondutor(montarRequest(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @PutMapping("/{condutorId}")
    public ResponseEntity<CondutorResponseDto> atualizarCondutor(@Valid @RequestBody CondutorRequestDto requestDto,
                                                                 @PathVariable(value = "condutorId") UUID condutorId) {
        var response = atualizarCondutor.atualizarCondutor((montarRequest(requestDto)), condutorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @GetMapping("/{condutorId}")
    public ResponseEntity<CondutorResponseDto> buscarCondutor(@PathVariable(value = "condutorId")UUID condutorId) {
        var response = buscarCondutor.buscarCondutor(condutorId);
        return ResponseEntity.status(HttpStatus.OK).body(converterResponse(response));
    }

    @DeleteMapping("/{condutorId}")
    public ResponseEntity<CondutorResponseDto> deletarCondutor(@PathVariable(value = "condutorId")UUID condutorId) {
        deletarCondutor.deletarCondutor(condutorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private CondutorRequest montarRequest(CondutorRequestDto requestDto) {
        return CondutorRequest.builder()
                .nome(requestDto.getNome())
                .telefone(requestDto.getTelefone())
                .email(requestDto.getEmail())
                .formaPagamento(requestDto.getFormaPagamento())
                .horaFixa(requestDto.isHoraFixa())
                .build();
    }

    private CondutorResponseDto converterResponse(CondutorResponse response) {
        return CondutorResponseDto.builder()
                .condutorId(response.getCondutorId())
                .nome(response.getNome())
                .telefone(response.getTelefone())
                .email(response.getEmail())
                .formaPagamento(response.getFormaPagamento())
                .build();
    }
}
