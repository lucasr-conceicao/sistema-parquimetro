package br.com.fiap.parquimetro.novo.adapters.rest.handler;

import br.com.fiap.parquimetro.novo.adapters.Exception.AdapterException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(AdapterException.class)
    private ResponseEntity<JsonHandler> badRequestHandler(Exception ex, HttpServletRequest httpServlet) {
        return montarRetorno(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), httpServlet.getRequestURI(), ex.getMessage());
    }

    private ResponseEntity<JsonHandler> montarRetorno(HttpStatus httpStatus, Integer code, String path, String mensagem) {
        return new ResponseEntity<>(new JsonHandler(LocalDateTime.now(), code , httpStatus, path, mensagem), httpStatus);
    }
}
