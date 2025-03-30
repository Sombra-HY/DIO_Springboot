package br.com.dio.controller;

import br.com.dio.exception.ProductEmpentyExceotion;
import br.com.dio.exception.ProductValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductEmpentyExceotion.class)
    public ResponseEntity<Object> GetErrorNull(){
        Map<String,Object> body = new HashMap<>();
        body.put("message","Verifique os campos do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    @ExceptionHandler(ProductValueException.class)
    public ResponseEntity<Object> GetErrorPriceValue(){
        Map<String,Object> body = new HashMap<>();
        body.put("message","O valor do produto nao pode ser zero negativo");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
