package br.com.fiap.parquimetro.novo.adapters.rest.controller;

import br.com.fiap.parquimetro.novo.adapters.rest.dto.condutor.CondutorRequestDto;
import br.com.fiap.parquimetro.novo.adapters.rest.dto.condutor.CondutorResponseDto;
import br.com.fiap.parquimetro.novo.adapters.rest.dto.veiculo.VeiculoRequestDto;
import br.com.fiap.parquimetro.novo.adapters.rest.dto.veiculo.VeiculoResponseDto;
import br.com.fiap.parquimetro.novo.usecase.database.condutor.*;
import br.com.fiap.parquimetro.novo.usecase.database.veiculo.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/veiculo")
public class VeiculoController {

    private final ICadastrarVeiculo cadastrarVeiculo;
    private final IBuscarVeiculo buscarVeiculo;
    private final IAtualizarVeiculo atualizarVeiculo;
    private final IDeletarVeiculo deletarVeiculo;

    @PostMapping
    public ResponseEntity<VeiculoResponseDto> cadastrarVeiculo(@Valid @RequestBody VeiculoRequestDto requestDto) {
        var response = cadastrarVeiculo.cadastrarVeiculo(montarRequest(requestDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @PutMapping("/{veiculoId}")
    public ResponseEntity<VeiculoResponseDto> atualizarVeiculo(@Valid @RequestBody VeiculoRequestDto requestDto,
                                                                 @PathVariable(value = "veiculoId") UUID veiculoId) {
        var response = atualizarVeiculo.atualizarVeiculo((montarRequest(requestDto)), veiculoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(converterResponse(response));
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoResponseDto> buscarVeiculo(@PathVariable(value = "veiculoId")UUID veiculoId) {
        var response = buscarVeiculo.buscarVeiculo(veiculoId);
        return ResponseEntity.status(HttpStatus.OK).body(converterResponse(response));
    }

    @DeleteMapping("/{veiculoId}")
    public ResponseEntity<CondutorResponseDto> deletarVeiculo(@PathVariable(value = "veiculoId")UUID veiculoId) {
        deletarVeiculo.deletarVeiculo(veiculoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private VeiculoRequest montarRequest(VeiculoRequestDto requestDto) {
        return VeiculoRequest.builder()
                .placa(requestDto.getPlaca())
                .marca(requestDto.getMarca())
                .modelo(requestDto.getModelo())
                .condutor(requestDto.getCondutor())
                .build();
    }

    private VeiculoResponseDto converterResponse(VeiculoResponse response) {
        return VeiculoResponseDto.builder()
                .veiculoId(response.getVeiculoId())
                .placa(response.getPlaca())
                .marca(response.getMarca())
                .modelo(response.getModelo())
                .condutor(response.getCondutor())
                .build();
    }
}
