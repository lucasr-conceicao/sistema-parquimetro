package br.com.fiap.parquimetro.novo.adapters.rest.controller;

import br.com.fiap.parquimetro.novo.adapters.rest.dto.condutor.CondutorResponseDto;
import br.com.fiap.parquimetro.novo.adapters.rest.dto.estacionamento.EstacionamentoRequestDto;
import br.com.fiap.parquimetro.novo.adapters.rest.dto.estacionamento.EstacionamentoResponseDto;
import br.com.fiap.parquimetro.novo.adapters.rest.dto.veiculo.VeiculoRequestDto;
import br.com.fiap.parquimetro.novo.adapters.rest.dto.veiculo.VeiculoResponseDto;
import br.com.fiap.parquimetro.novo.usecase.calcularpagamento.CalcularPagamentoResponse;
import br.com.fiap.parquimetro.novo.usecase.calcularpagamento.ICalcularPagamento;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.EstacionamentoRequest;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.EstacionamentoResponse;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.IBuscarEstacionamento;
import br.com.fiap.parquimetro.novo.usecase.database.estacionamento.IEstacionamento;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.ICadastrarVeiculo;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.VeiculoRequest;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.VeiculoResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    private final IEstacionamento estacionamento;
    private final IBuscarEstacionamento buscarEstacionamento;
    private final ICalcularPagamento calcularPagamento;

    @PostMapping("/iniciar")
    public ResponseEntity<EstacionamentoResponseDto> cadastrarCondutor(@Valid @RequestBody EstacionamentoRequestDto requestDto) {
        var response = estacionamento.iniciarEstacionamento(montarRequest(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @GetMapping("/{estacionamentoId}")
    public ResponseEntity<EstacionamentoResponseDto> buscarCondutor(@PathVariable(value = "estacionamentoId") UUID estacionamentoId) {
        var response = buscarEstacionamento.buscarEstacionamento(estacionamentoId);
        return ResponseEntity.status(HttpStatus.OK).body(converterResponse(response));
    }

    @GetMapping("/calcular_pagametno/{estacionamentoId}")
    public ResponseEntity<EstacionamentoResponseDto> calcularPagamento(@PathVariable(value = "estacionamentoId") UUID estacionamentoId) {
        var response = calcularPagamento.calcularPagamento(estacionamentoId);
        return ResponseEntity.status(HttpStatus.OK).body(converterResponse(response));
    }

    private EstacionamentoRequest montarRequest(EstacionamentoRequestDto requestDto) {
        return EstacionamentoRequest.builder()
                .veiculoId(requestDto.getVeiculoId())
                .estacionamentoFixo(requestDto.isEstacionamentoFixo())
                .valor(requestDto.getValor())
                .formaDePagamento(requestDto.getFormaDePagamento())
                .horarioFim(requestDto.getHorarioFim())
                .horarioInicio(requestDto.getHorarioInicio())
                .build();
    }

    private EstacionamentoResponseDto converterResponse(EstacionamentoResponse response) {
        return EstacionamentoResponseDto.builder()
                .estacionamentoId(response.getEstacionamentoId())
                .veiculoId(response.getVeiculoId())
                .estacionamentoFixo(response.isEstacionamentoFixo())
                .valor(response.getValor())
                .formaDePagamento(response.getFormaDePagamento())
                .horarioFim(response.getHorarioFim())
                .horarioInicio(response.getHorarioInicio())
                .estacionamentoFixo(response.isEstacionamentoFixo())
                .build();
    }

    private EstacionamentoResponseDto converterResponse(CalcularPagamentoResponse response) {
        return EstacionamentoResponseDto.builder()
                .estacionamentoId(response.getEstacionamentoId())
                .veiculoId(response.getVeiculoId())
                .estacionamentoFixo(response.isEstacionamentoFixo())
                .valor(response.getValor())
                .formaDePagamento(response.getFormaDePagamento())
                .horarioFim(response.getHorarioFim())
                .horarioInicio(response.getHorarioInicio())
                .estacionamentoFixo(response.isEstacionamentoFixo())
                .build();
    }

}
